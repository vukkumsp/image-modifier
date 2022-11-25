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


    
    public void applyDemoEffect(String destinationPath){
        ImagePlus imp = IJ.openImage(this.imagePath);
        

        if(imp == null){
            System.out.println("image path is "+ this.imagePath);
            System.out.println("imp is null");
            return;
        }

        ImageProcessor ip = imp.getProcessor();
        ip.setColor(Color.BLUE);
        ip.setLineWidth(4);
        ip.drawRect(10, 10, imp.getWidth() - 20, imp.getHeight() - 20);

        IJ.saveAs(imp, "jpg", destinationPath);

        // imp.show();
    }

    public void applyDemoEffect2(String destinationPath) throws IOException{
        MBFImage image = ImageUtilities.readMBF(new File(this.imagePath));

        if(image == null){
            System.out.println("image path is "+ this.imagePath);
            System.out.println("imp is null");
            return;
        }

        for (int y=0; y<image.getHeight(); y++) {
            for(int x=0; x<image.getWidth(); x++) {
                image.getBand(1).pixels[y][x] = 0;
                image.getBand(2).pixels[y][x] = 0;
            }
        }

        image.drawShapeFilled(new Ellipse(700f, 450f, 20f, 10f, 0f), RGBColour.WHITE);
        image.drawShapeFilled(new Ellipse(650f, 425f, 25f, 12f, 0f), RGBColour.WHITE);
        image.drawShapeFilled(new Ellipse(600f, 380f, 30f, 15f, 0f), RGBColour.WHITE);
        image.drawShapeFilled(new Ellipse(500f, 300f, 100f, 70f, 0f), RGBColour.WHITE);
        image.drawText("OpenIMAJ is", 425, 300, HersheyFont.ASTROLOGY, 20, RGBColour.BLACK);
        image.drawText("Awesome", 425, 330, HersheyFont.ASTROLOGY, 20, RGBColour.BLACK);

        ImageUtilities.write(image, new File(destinationPath));
        

    }
}
