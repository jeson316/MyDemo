package com.lee.jeson316.mydemo.showmessage;

public class PictureDetail implements IPitctureDetail {
    private int imageId;
    private int descriptId;
    private boolean check;
    private int type = 0;


    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public PictureDetail(int imageId, int descriptId) {
        this.imageId = imageId;
        this.descriptId = descriptId;
    }

    public PictureDetail(int imageId, int descriptId, int type) {
        this.imageId = imageId;
        this.descriptId = descriptId;
        this.type = type;
    }

    @Override
    public int getImageId() {
        return imageId;
    }

    @Override
    public int descrpitionId() {
        return descriptId;
    }

    @Override
    public boolean isChecked() {
        return check;
    }

    @Override
    public void setChecked(boolean check) {
        this.check = check;
    }

    @Override
    public int itemType() {
        return getType();
    }
}
