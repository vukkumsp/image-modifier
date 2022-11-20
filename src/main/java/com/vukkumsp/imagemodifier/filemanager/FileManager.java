package com.vukkumsp.imagemodifier.filemanager;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileManager {

    Logger logger = LoggerFactory.getLogger(FileManager.class);


    String sampleImageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/132.png";

    URL baseUrl;

    public FileManager() throws MalformedURLException {
        this.baseUrl = new URL(
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork");
    }

    public void getFile1() throws MalformedURLException {
        // passing url to URL class
        // URL url=new URL(this.baseUrl, "/132.png");
        URL url1 = new URL(this.sampleImageUrl);
        System.out.println(" Url: " + url1);
        // Fetching file name
        System.out.println("File name in given url is : " + url1.getFile());
    }

    public void getFile() {
        logger.info("getFile started");
        try (BufferedInputStream in = new BufferedInputStream(new URL(sampleImageUrl).openStream());
                FileOutputStream fileOutputStream = new FileOutputStream("FILE_NAME")) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                // fileOutputStream.write(dataBuffer, 0, bytesRead);
                // System.out.write(dataBuffer,0,bytesRead);
                System.out.println("----");
            }
        } catch (IOException e) {
            // handle exception
        }
        logger.info("getFile ended");
    }
}
