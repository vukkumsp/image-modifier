package com.vukkumsp.imagemodifier.rest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vukkumsp.imagemodifier.effectsmanager.EffectsManager;
import com.vukkumsp.imagemodifier.exceptions.GlobalException;
import com.vukkumsp.imagemodifier.filemanager.LocalFileManager;
import com.vukkumsp.imagemodifier.model.SimpleRequest;

@RestController
class MainController {
  Logger logger = LoggerFactory.getLogger(MainController.class);

  @GetMapping("/dummy0")
  String dummyEndpoint0() throws MalformedURLException {
    LocalFileManager fm = new LocalFileManager();

    fm.setImagesFolder("C://Users//vukku//Documents//ImageDestination//");
    String path = fm.saveImageFile(LocalFileManager.sampleImageUrl2);

    logger.info("Path: {}", path);
    return "dummy";
  }

  @GetMapping("/dummy1")
  String dummyEndpoint1() throws IOException {

    EffectsManager em = new EffectsManager(LocalFileManager.sampleImageUrl2);

    em.applyDemoEffect2("C://Users//vukku//Documents//ImageDestination//im2.png");

    return "dummy1";
  }

  // https://www.baeldung.com/spring-controller-return-image-file
  // https://www.baeldung.com/convert-file-to-input-stream
  @GetMapping(value = "/shadeIt", produces = MediaType.IMAGE_PNG_VALUE)
  public @ResponseBody byte[] getImage() throws IOException {
    EffectsManager em = new EffectsManager(LocalFileManager.sampleImageUrl2);

    em.applyDemoEffect2("C://Users//vukku//Documents//ImageDestination//im2.png");

    File initialFile = new File("C://Users//vukku//Documents//ImageDestination//im2.png");
    InputStream targetStream = new FileInputStream(initialFile);

    return IOUtils.toByteArray(targetStream);
  }

  @PostMapping(value = "/shadeIt2", produces = MediaType.IMAGE_PNG_VALUE)
  public @ResponseBody byte[] postImage(@RequestBody SimpleRequest simpleRequest) throws IOException {
    //works only for local image links
    //example: "C://Users//vukku//Documents//ImageSource//132.png"
    EffectsManager em = new EffectsManager(simpleRequest.getImageSourcePath());

    em.applyDemoEffect2("C://Users//vukku//Documents//ImageDestination//im2.png");

    File initialFile = new File("C://Users//vukku//Documents//ImageDestination//im2.png");
    InputStream targetStream = new FileInputStream(initialFile);

    return IOUtils.toByteArray(targetStream);
  }

  @PostMapping(value = "/shadeIt3", produces = MediaType.IMAGE_PNG_VALUE)
  public @ResponseBody byte[] postImage2(@RequestBody SimpleRequest simpleRequest) throws IOException {
    
    LocalFileManager fm = new LocalFileManager();

    InputStream in = new URL(simpleRequest.getImageSourcePath()).openStream();
    Files.copy(in, Paths.get("C://Users//vukku//Documents//ImageSource//newFile.png"), StandardCopyOption.REPLACE_EXISTING);

    // String localPath = fm.fileUpload(new File(simpleRequest.getImageSourcePath()));

    EffectsManager em = new EffectsManager("C://Users//vukku//Documents//ImageSource//newFile.png");

    em.applyDemoEffect2("C://Users//vukku//Documents//ImageDestination//newFile.png");

    File initialFile = new File("C://Users//vukku//Documents//ImageDestination//im2.png");
    InputStream targetStream = new FileInputStream(initialFile);

    return IOUtils.toByteArray(targetStream);
  }

  @GetMapping("/throwException")
  String throwException() {
    throw new GlobalException("failed");
  }
}