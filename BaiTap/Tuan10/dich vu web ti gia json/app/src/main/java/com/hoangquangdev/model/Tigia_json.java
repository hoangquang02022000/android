package com.hoangquangdev.model;

import android.graphics.Bitmap;

public class Tigia_json {
    private String type;
    private String imageurl;
    private Bitmap bitmap;
    private String muatienmat;
    private String muack;
    private String bantienmat;
    private String banck;

    public Tigia_json(){

    }

    public Tigia_json(String type, String imageurl, Bitmap bitmap, String muatienmat, String muack, String bantienmat, String banck) {
        this.type = type;
        this.imageurl = imageurl;
        this.bitmap = bitmap;
        this.muatienmat = muatienmat;
        this.muack = muack;
        this.bantienmat = bantienmat;
        this.banck = banck;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getMuatienmat() {
        return muatienmat;
    }

    public void setMuatienmat(String muatienmat) {
        this.muatienmat = muatienmat;
    }

    public String getMuack() {
        return muack;
    }

    public void setMuack(String muack) {
        this.muack = muack;
    }

    public String getBantienmat() {
        return bantienmat;
    }

    public void setBantienmat(String bantienmat) {
        this.bantienmat = bantienmat;
    }

    public String getBanck() {
        return banck;
    }

    public void setBanck(String banck) {
        this.banck = banck;
    }

    @Override
    public String toString() {
        return "Tigia_json{" +
                "type='" + type + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", bitmap=" + bitmap +
                ", muatienmat='" + muatienmat + '\'' +
                ", muack='" + muack + '\'' +
                ", bantienmat='" + bantienmat + '\'' +
                ", banck='" + banck + '\'' +
                '}';
    }
}
