package com.vukkumsp.imagemodifier.effectsmanager;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.image.typography.hershey.HersheyFont;
import org.openimaj.math.geometry.shape.Ellipse;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

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

        // for (int y=0; y<image.getHeight(); y++) {
        // // Converts image to red filtered
        //     for(int x=0; x<image.getWidth(); x++) {
        //         image.getBand(1).pixels[y][x] = 0;
        //         image.getBand(2).pixels[y][x] = 0;
        //     }
        // }

        // image.drawShapeFilled(new Ellipse(700f, 450f, 20f, 10f, 0f), RGBColour.WHITE);
        // image.drawShapeFilled(new Ellipse(650f, 425f, 25f, 12f, 0f), RGBColour.WHITE);
        // image.drawShapeFilled(new Ellipse(600f, 380f, 30f, 15f, 0f), RGBColour.WHITE);
        // image.drawShapeFilled(new Ellipse(500f, 300f, 100f, 70f, 0f), RGBColour.WHITE);
        // image.drawText("OpenIMAJ is", 200, 300, HersheyFont.ASTROLOGY, 20, RGBColour.BLACK);
        // image.drawText("Awesome", 200, 330, HersheyFont.ASTROLOGY, 20, RGBColour.BLACK);

        ImageUtilities.write(image, new File(destinationPath));
        
    }
}
