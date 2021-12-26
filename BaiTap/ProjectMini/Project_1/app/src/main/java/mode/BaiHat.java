package mode;

import java.io.Serializable;

public class BaiHat implements Serializable {
    private int img;
    private String tenBH;
    private String tenCS;
    private boolean state;

    public BaiHat() {
    }

    public BaiHat(int img, String tenBH, String tenCS, boolean state) {
        this.img = img;
        this.tenBH = tenBH;
        this.tenCS = tenCS;
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public String getTenCS() {
        return tenCS;
    }

    public void setTenCS(String tenCS) {
        this.tenCS = tenCS;
    }
}
