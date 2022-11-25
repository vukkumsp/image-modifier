package com.vukkumsp.imagemodifier.filemanager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileManager {
    static String srcFolderPath = "C://Users//vukku//Documents//ImageSource";
    static String desFolderPath = "C://Users//vukku//Documents//ImageDestination";
    static String divider = "//";
    public static enum Env {
        LOCAL
    };

    URL baseUrl;

    public FileManager(String fileSourceLink) throws MalformedURLException{
        this.baseUrl = new URL(fileSourceLink);
    }

    public FileManager() {
    }

    public String uploadFileFromLink(String onlineLink, Env env) throws MalformedURLException, IOException {
        switch(env){
            case LOCAL:
                return this.localUploadFileFromLink(onlineLink);
        }
        return null;
    }

    public String getFileNameFromOnlineLink(String onlineLink) {
        String[] strArr = onlineLink.split("/");
        if(strArr.length > 0){
            return strArr[strArr.length-1];
        }
        return null;
    }

    public String generateDesPath(String onlineLink, Env env) {
        switch(env){
            case LOCAL:
                return this.localGenerateDesPath(onlineLink);
        }
        return null;
    }

    /* 
     * LOCAL File Storage methods
     */

     //https://www.baeldung.com/java-download-file
    private String localUploadFileFromLink(String onlineLink) throws MalformedURLException, IOException {
        String uploadSrcPath = srcFolderPath + divider + getFileNameFromOnlineLink(onlineLink);
        
        // Method 1: keeps the file in buffer of app memory
        // InputStream in = new URL(onlineLink).openStream();
        // Files.copy(in, Paths.get(uploadSrcPath), StandardCopyOption.REPLACE_EXISTING);
        

        // Method 2: file data will be passed from input stream to output stream without buffer in app memory
        ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(onlineLink).openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(uploadSrcPath);
        fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        fileOutputStream.close();

        return uploadSrcPath;
    }

    private String localGenerateDesPath(String onlineLink) {
        return desFolderPath + divider + getFileNameFromOnlineLink(onlineLink);
    }
}
