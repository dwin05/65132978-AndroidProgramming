package com.quynh.thigk2nguyenthidiemquynh;

public class DiaDiem {
    private String ten;
    private String diaChi;
    private int hinhAnh; // Lưu ID của hình ảnh trong thư mục drawable

    public DiaDiem(String ten, String diaChi, int hinhAnh) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }
}