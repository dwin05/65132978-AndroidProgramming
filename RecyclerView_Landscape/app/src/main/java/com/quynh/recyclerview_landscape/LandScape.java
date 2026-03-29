package com.quynh.recyclerview_landscape;

public class LandScape {
    String fileImage;
    String cantion;

    public LandScape(String fileImage, String cantion) {
        this.fileImage = fileImage;
        this.cantion = cantion;
    }

    public String getFileImage() {
        return fileImage;
    }

    public void setFileImage(String fileImage) {
        this.fileImage = fileImage;
    }

    public String getCantion() {
        return cantion;
    }

    public void setCantion(String cantion) {
        this.cantion = cantion;
    }
}
