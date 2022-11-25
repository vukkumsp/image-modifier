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
import com.vukkumsp.imagemodifier.services.ImageModifierService;
import com.vukkumsp.imagemodifier.services.FileManager.Env;

@RestController
class MainController {
  Logger logger = LoggerFactory.getLogger(MainController.class);

  @PostMapping(value = "/applyEffect", produces = MediaType.IMAGE_PNG_VALUE)
  public @ResponseBody byte[] applyEffect(@RequestBody SimpleRequest simpleRequest) throws IOException {
    logger.info("Endpoint /applyEffect started with request {}", simpleRequest);
    
    ImageModifierService ims = new ImageModifierService();
    byte[] response = ims.applyEffect(simpleRequest.getImageSourcePath(), simpleRequest.getEffect(), Env.LOCAL);
    
    logger.info("Endpoint /applyEffect ended");
    return response;
  }

  @GetMapping("/throwException")
  String throwException() {
    throw new GlobalException("failed");
  }
}