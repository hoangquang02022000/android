package mode;

import java.io.Serializable;

public class BaiHat implements Serializable {
    private String maBH;
    private String tenBH;
    private String lyric;
    private String tenCS;
    private String category;
    private int stt;
    private int yt;

    public BaiHat() {
    }

    public BaiHat(String maBH, String tenBH, String lyric, String tenCS, String category, int stt, int yt) {
        this.maBH = maBH;
        this.tenBH = tenBH;
        this.lyric = lyric;
        this.tenCS = tenCS;
        this.category = category;
        this.stt = stt;
        this.yt = yt;
    }

    public String getMaBH() {
        return maBH;
    }

    public void setMaBH(String maBH) {
        this.maBH = maBH;
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getTenCS() {
        return tenCS;
    }

    public void setTenCS(String tenCS) {
        this.tenCS = tenCS;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getYt() {
        return yt;
    }

    public void setYt(int yt) {
        this.yt = yt;
    }
}
