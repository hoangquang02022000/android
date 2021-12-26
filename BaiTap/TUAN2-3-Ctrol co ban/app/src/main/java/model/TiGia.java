package model;

import java.io.Serializable;

public class TiGia implements Serializable {
    private String kyHieu;
    private int img;
    private long giamuaTM;
    private long giabanTM;
    private long giamuaCK;
    private long giabanCK;

    public TiGia(String kyHieu, int img,long giamauTM, long giabanTM, long giamuaCK, long giabanCK) {
        this.kyHieu = kyHieu;
        this.img = img;
        this.giamuaTM = giamauTM;
        this.giabanTM = giabanTM;
        this.giamuaCK = giamuaCK;
        this.giabanCK = giabanCK;

    }

    public TiGia() {
    }

    public String getKyHieu() {
        return kyHieu;
    }

    public void setKyHieu(String kyHieu) {
        this.kyHieu = kyHieu;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public long getGiamuaTM() {
        return giamuaTM;
    }

    public void setGiamuaTM(long giamuaTM) {
        this.giamuaTM = giamuaTM;
    }

    public long getGiamauTM() {
        return giamuaTM;
    }

    public void setGiamauTM(long giamauTM) {
        this.giamuaTM = giamauTM;
    }

    public long getGiabanTM() {
        return giabanTM;
    }

    public void setGiabanTM(long giabanTM) {
        this.giabanTM = giabanTM;
    }

    public long getGiamuaCK() {
        return giamuaCK;
    }

    public void setGiamuaCK(long giamuaCK) {
        this.giamuaCK = giamuaCK;
    }

    public long getGiabanCK() {
        return giabanCK;
    }

    public void setGiabanCK(long giabanCK) {
        this.giabanCK = giabanCK;
    }

}
