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

  @GetMapping("/throwException")
  String throwException(){
    throw new GlobalException("failed");
  }
}