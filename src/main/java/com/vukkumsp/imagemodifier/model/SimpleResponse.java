package com.vukkumsp.imagemodifier.model;

public class SimpleResponse {
    String imageSourceLink;
    byte[] imageData;
    String effectApplied;

    public SimpleResponse(String imageSourceLink, byte[] imageData, String effectApplied) {
        this.imageSourceLink = imageSourceLink;
        this.imageData = imageData;
        this.effectApplied = effectApplied;
    }

    public byte[] getImageData() {
        return this.imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getEffectApplied() {
        return this.effectApplied;
    }

    public void setEffectApplied(String effectApplied) {
        this.effectApplied = effectApplied;
    }

    public String getImageSourceLink() {
        return this.imageSourceLink;
    }

    public void setImageSourceLink(String imageSourceLink) {
        this.imageSourceLink = imageSourceLink;
    }

    @Override
    public String toString() {
        return "{" +
            " imageSourceLink='" + getImageSourceLink() + "'" +
            ", effectApplied='" + getEffectApplied() + "'" +
            "}";
    }
}

