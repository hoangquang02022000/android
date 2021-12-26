package model;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private int maNV;
    private String tenNV;
    private boolean gioTinh;

    public NhanVien(String s, String tenNV, boolean gioTinh) {
    }

    public NhanVien(int maNV, String tenNV, boolean gioTinh) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioTinh = gioTinh;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public boolean isGioTinh() {
        return gioTinh;
    }

    public void setGioTinh(boolean gioTinh) {
        this.gioTinh = gioTinh;
    }
}
