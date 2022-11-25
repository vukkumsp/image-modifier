package com.vukkumsp.imagemodifier.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

import com.vukkumsp.imagemodifier.exceptions.GlobalException;
import com.vukkumsp.imagemodifier.model.SimpleRequest;
import com.vukkumsp.imagemodifier.services.EffectsManager;
import com.vukkumsp.imagemodifier.services.FileManager;
import com.vukkumsp.imagemodifier.services.FileManager.Env;

@RestController
class MainController {
  Logger logger = LoggerFactory.getLogger(MainController.class);

  @PostMapping(value = "/shadeIt3", produces = MediaType.IMAGE_PNG_VALUE)
  public @ResponseBody byte[] postImage2(@RequestBody SimpleRequest simpleRequest) throws IOException {
    
    FileManager fm = new FileManager();
    String uploadedFilePath = fm.uploadFileFromLink(simpleRequest.getImageSourcePath(), Env.LOCAL);

    InputStream in = new URL(simpleRequest.getImageSourcePath()).openStream();
    Files.copy(in, Paths.get(uploadedFilePath), StandardCopyOption.REPLACE_EXISTING);

    // String localPath = fm.fileUpload(new File(simpleRequest.getImageSourcePath()));

    EffectsManager em = new EffectsManager(uploadedFilePath);

    String desFilePath = fm.generateDesPath(simpleRequest.getImageSourcePath(), Env.LOCAL);

    em.applyDemoEffect2(desFilePath);

    File initialFile = new File(desFilePath);
    InputStream targetStream = new FileInputStream(initialFile);

    return IOUtils.toByteArray(targetStream);
  }

  @GetMapping("/throwException")
  String throwException() {
    throw new GlobalException("failed");
  }
}