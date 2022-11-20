package com.vukkumsp.imagemodifier.rest;

import java.net.MalformedURLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vukkumsp.imagemodifier.filemanager.FileManager;

@RestController
class MainController {

  @GetMapping("/dummy")
  String dummyEndpoint() throws MalformedURLException {
    FileManager fm = new FileManager();
    fm.getFile();
    return "dummy";
  }
}