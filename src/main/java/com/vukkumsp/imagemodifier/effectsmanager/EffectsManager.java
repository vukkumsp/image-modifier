package com.vukkumsp.imagemodifier.effectsmanager;

import java.awt.Color;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.Colors;
import ij.process.ImageProcessor;

public class EffectsManager {

    String imagePath;

    public EffectsManager(String path){
        this.imagePath = path;
    }
    
    public void applyDemoEffect(){
        ImagePlus imp = IJ.openImage(this.imagePath);

        ImageProcessor ip = imp.getProcessor();
        ip.setColor(Color.BLUE);
        ip.setLineWidth(4);
        ip.drawRect(10, 10, imp.getWidth() - 20, imp.getHeight() - 20);

        // imp.show();
    }
}
