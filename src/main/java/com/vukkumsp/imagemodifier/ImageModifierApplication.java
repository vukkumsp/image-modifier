package com.vukkumsp.imagemodifier;

import java.net.MalformedURLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vukkumsp.imagemodifier.filemanager.LocalFileManager;

@SpringBootApplication
public class ImageModifierApplication {

	public static void main(String[] args) throws MalformedURLException {
		SpringApplication.run(ImageModifierApplication.class, args);
	}

}
