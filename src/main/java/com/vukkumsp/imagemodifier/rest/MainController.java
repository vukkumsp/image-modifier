package com.vukkumsp.imagemodifier.rest;

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

    logger.info(path);
    return "dummy";
  }

  @GetMapping("/throwException")
  String dummyEndpoint2(){
    throw new GlobalException("failed");
  }
}