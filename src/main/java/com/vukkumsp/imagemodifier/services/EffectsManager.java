package com.vukkumsp.imagemodifier.services;

import java.io.File;
import java.io.IOException;

import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;

public class EffectsManager {

    String imagePath;

    public EffectsManager(String path){
        this.imagePath = path;
    }

    public void applyDemoEffect2(String destinationPath) throws IOException{
        // http://openimaj.org/tutorial/index.html
        MBFImage image = ImageUtilities.readMBFAlpha(new File(this.imagePath));

        
        // ImageUtilities.readMBFAlpha(null)

        if(image == null){
            System.out.println("image path is "+ this.imagePath);
            System.out.println("imp is null");
            return;
        }

        for (int y=0; y<image.getHeight(); y++) {
        // shade it
            for(int x=0; x<image.getWidth(); x++) {
                image.getBand(0).pixels[y][x] = 0; //red
                image.getBand(1).pixels[y][x] = 0; //blue
                image.getBand(2).pixels[y][x] = 0; //green
                
            }
        }


        ImageUtilities.write(image, new File(destinationPath));

        
    }
}
