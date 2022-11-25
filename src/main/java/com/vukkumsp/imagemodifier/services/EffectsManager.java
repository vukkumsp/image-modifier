package com.vukkumsp.imagemodifier.services;

import java.io.File;
import java.io.IOException;

import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;

public class EffectsManager {

    String imagePath;

    public static enum Effect {
        SILHOUETTE
    };

    public EffectsManager(String path) {
        this.imagePath = path;
    }

    public void applyEffect(String destinationPath, Effect effect) throws IOException {
        // http://openimaj.org/tutorial/index.html
        MBFImage image = ImageUtilities.readMBFAlpha(new File(this.imagePath));

        switch(effect) {
            case SILHOUETTE:
                applySilhouetteEffect(image);
                break;
        }
        
        ImageUtilities.write(image, new File(destinationPath));
    }

    void applySilhouetteEffect(MBFImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            // shade it
            for (int x = 0; x < image.getWidth(); x++) {
                image.getBand(0).pixels[y][x] = 0; // red
                image.getBand(1).pixels[y][x] = 0; // blue
                image.getBand(2).pixels[y][x] = 0; // green
            }
        }
    }
}
