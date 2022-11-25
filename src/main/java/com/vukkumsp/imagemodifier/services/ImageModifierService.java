package com.vukkumsp.imagemodifier.services;

import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.IOUtils;

import com.vukkumsp.imagemodifier.services.FileManager.Env;

public class ImageModifierService {

    public byte[] applyEffect(String imageLink, Env env) throws MalformedURLException, IOException {

        FileManager fm = new FileManager();
        String uploadedFilePath = fm.uploadFileFromLink(imageLink, Env.LOCAL);

        EffectsManager em = new EffectsManager(uploadedFilePath);

        String desFilePath = fm.generateDesPath(imageLink, Env.LOCAL);

        em.applyDemoEffect2(desFilePath);

        InputStream targetStream = new FileInputStream(new File(desFilePath));

        return IOUtils.toByteArray(targetStream);
    }

}
