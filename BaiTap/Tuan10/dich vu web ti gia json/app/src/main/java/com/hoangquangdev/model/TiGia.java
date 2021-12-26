package com.hoangquangdev.model;

import java.io.Serializable;

public class TiGia implements Serializable {
    private int ID_Img;
    private String kihieu;
    private Long muaTM;
    private Long banTM;
    private Long muaCK;
    private Long banCK;

    public TiGia(){

    }

    public TiGia(int ID_Img, String kihieu, Long muaTM, Long banTM, Long muaCK, Long banCK) {
        this.ID_Img = ID_Img;
        this.kihieu = kihieu;
        this.muaTM = muaTM;
        this.banTM = banTM;
        this.muaCK = muaCK;
        this.banCK = banCK;
    }


    public int getID_Img() {
        return ID_Img;
    }

    public void setID_Img(int ID_Img) {
        this.ID_Img = ID_Img;
    }

    public String getKihieu() {
        return kihieu;
    }

    public void setKihieu(String kihieu) {
        this.kihieu = kihieu;
    }

    public Long getMuaTM() {
        return muaTM;
    }

    public void setMuaTM(Long muaTM) {
        this.muaTM = muaTM;
    }

    public Long getBanTM() {
        return banTM;
    }

    public void setBanTM(Long banTM) {
        this.banTM = banTM;
    }

    public Long getMuaCK() {
        return muaCK;
    }

    public void setMuaCK(Long muaCK) {
        this.muaCK = muaCK;
    }

    public Long getBanCK() {
        return banCK;
    }

    public void setBanCK(Long banCK) {
        this.banCK = banCK;
    }
}
