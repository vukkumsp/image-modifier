package com.vukkumsp.imagemodifier.rest;

import java.io.IOException;
import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vukkumsp.imagemodifier.effectsmanager.EffectsManager;
import com.vukkumsp.imagemodifier.exceptions.GlobalException;
import com.vukkumsp.imagemodifier.filemanager.LocalFileManager;

@RestController
class MainController {
  Logger logger = LoggerFactory.getLogger(MainController.class);

  @GetMapping("/dummy")
  String dummyEndpoint() throws MalformedURLException {
    LocalFileManager fm = new LocalFileManager();
    // fm.getFile();
    //-----------
    // EffectsManager em = new EffectsManager(FileManager.sampleImageUrl);
    // em.applyDemoEffect();
    //--------
    fm.setImagesFolder("C://Users//vukku//Documents//ImageDestination//");
    String path = fm.saveImageFile(LocalFileManager.sampleImageUrl2);

    logger.info("Path: {}", path);
    return "dummy";
  }

  @GetMapping("/dummy2")
  String dummyEndpoint2() throws MalformedURLException {
    LocalFileManager fm = new LocalFileManager();
    // fm.getFile();
    //-----------
    // EffectsManager em = new EffectsManager(FileManager.sampleImageUrl);
    // em.applyDemoEffect();
    //--------
    // fm.setImagesFolder("C://Users//vukku//Documents//ImageDestination//");

    EffectsManager em = new EffectsManager(LocalFileManager.sampleImageUrl2);

    em.applyDemoEffect("C://Users//vukku//Documents//ImageDestination//");
    

    // String path = fm.saveImageFile(LocalFileManager.sampleImageUrl2);

    // logger.info("Path: {}", path);
    return "dummy2";
  }

  @GetMapping("/dummy3")
  String dummyEndpoint3() throws IOException {
    LocalFileManager fm = new LocalFileManager();
    // fm.getFile();
    //-----------
    // EffectsManager em = new EffectsManager(FileManager.sampleImageUrl);
    // em.applyDemoEffect();
    //--------
    // fm.setImagesFolder("C://Users//vukku//Documents//ImageDestination//");

    EffectsManager em = new EffectsManager(LocalFileManager.sampleImageUrl2);

    em.applyDemoEffect2("C://Users//vukku//Documents//ImageDestination//im2.jpeg");
    

    // String path = fm.saveImageFile(LocalFileManager.sampleImageUrl2);

    // logger.info("Path: {}", path);
    return "dummy3";
  }

  @GetMapping("/throwException")
  String throwException(){
    throw new GlobalException("failed");
  }
}