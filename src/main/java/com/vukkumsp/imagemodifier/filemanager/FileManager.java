package com.vukkumsp.imagemodifier.filemanager;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileManager {
    static String srcFolderPath = "C://Users//vukku//Documents//ImageSource";
    static String desFolderPath = "C://Users//vukku//Documents//ImageDestination";
    static String divider = "//";

    URL baseUrl;

    public FileManager(String fileSourceLink) throws MalformedURLException{
        this.baseUrl = new URL(fileSourceLink);
    }

    public FileManager() {
    }

    public String uploadFileFromLink(String onlineLink) throws MalformedURLException, IOException {
        String uploadSrcPath = srcFolderPath + divider + getFileNameFromOnlineLink(onlineLink);
        InputStream in = new URL(onlineLink).openStream();
        Files.copy(in, Paths.get(uploadSrcPath), StandardCopyOption.REPLACE_EXISTING);
        return uploadSrcPath;
    }

    public String getFileNameFromOnlineLink(String onlineLink) {
        String[] strArr = onlineLink.split("/");
        if(strArr.length > 0){
            return strArr[strArr.length-1];
        }
        return null;
    }

    public String generateDesPath(String onlineLink) {
        return desFolderPath + divider + getFileNameFromOnlineLink(onlineLink);
    }
}
