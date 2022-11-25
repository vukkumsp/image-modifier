package com.vukkumsp.imagemodifier.rest;

import java.io.IOException;

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
import com.vukkumsp.imagemodifier.model.SimpleResponse;
import com.vukkumsp.imagemodifier.services.ImageModifierService;
import com.vukkumsp.imagemodifier.services.FileManager.Env;

@RestController
class MainController {
  Logger logger = LoggerFactory.getLogger(MainController.class);

  @PostMapping(value = "/applyEffect", produces = MediaType.IMAGE_PNG_VALUE)
  public @ResponseBody byte[] applyEffect(@RequestBody SimpleRequest simpleRequest) throws IOException {
    logger.info("Endpoint /applyEffect started with request {}", simpleRequest);
    
    ImageModifierService ims = new ImageModifierService();
    byte[] imageData = ims.applyEffect(simpleRequest.getImageSourcePath(), simpleRequest.getEffect(), Env.LOCAL);
    SimpleResponse simpleResponse = new SimpleResponse(simpleRequest, imageData);
    
    logger.info("Endpoint /applyEffect ended with response {}", simpleResponse);
    return simpleResponse.getImageData();
  }

  @GetMapping("/throwException")
  String throwException() {
    throw new GlobalException("failed");
  }
}