package com.vukkumsp.imagemodifier.filemanager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalFileManager {

    Logger logger = LoggerFactory.getLogger(LocalFileManager.class);

    public static String sampleImageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/132.png";
    public static String sampleImageUrl2 = "C://Users//vukku//Documents//ImageSource//132.png";

    URL baseUrl;

    public LocalFileManager() throws MalformedURLException {
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

    public String saveImageFile(String imageFilePath) {

        return this.fileUpload(new File(imageFilePath));

    }

    private String imagesFolder;

    public void setImagesFolder(String imagesFolder) {
        logger.info("setImagesFolder started");
        this.imagesFolder = imagesFolder;
        logger.info("setImagesFolder started");
    }

    public String fileUpload(File file) {
        logger.info("fileUpload started");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        // MultipartFile file = uploadedFile.getFile();
        String fileName = file.getName();
        File newFile = new File(imagesFolder + fileName);

        try {
            inputStream = new FileInputStream(file);

            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            outputStream = new FileOutputStream(newFile);
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("fileUpload started");
        return newFile.getAbsolutePath();
    }
}
