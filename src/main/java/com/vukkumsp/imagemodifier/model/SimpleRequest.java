package com.vukkumsp.imagemodifier.model;

public class SimpleRequest {
    private String imageSourcePath;
    private String effect;

    public String getImageSourcePath() {
        return this.imageSourcePath;
    }

    public void setImageSourcePath(String imageSourcePath) {
        this.imageSourcePath = imageSourcePath;
    }

    public String getEffect() {
        return this.effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

}
