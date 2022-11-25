package com.vukkumsp.imagemodifier.filemanager;

import java.net.MalformedURLException;
import java.net.URL;

public class FileManager {
    URL baseUrl;

    public FileManager(String fileSourceLink) throws MalformedURLException{
        this.baseUrl = new URL(fileSourceLink);
    }
}
