package com.quynh.optap1; // Thay bằng package của bạn nếu khác

public class BaiThuoc {
    private int hinhAnh;
    private String tenBaiThuoc;
    private String thoiGian;
    private String moTa; // Dùng cho màn hình chi tiết

    public BaiThuoc(int hinhAnh, String tenBaiThuoc, String thoiGian, String moTa) {
        this.hinhAnh = hinhAnh;
        this.tenBaiThuoc = tenBaiThuoc;
        this.thoiGian = thoiGian;
        this.moTa = moTa;
    }

    public int getHinhAnh() { return hinhAnh; }
    public String getTenBaiThuoc() { return tenBaiThuoc; }
    public String getThoiGian() { return thoiGian; }
    public String getMoTa() { return moTa; }
}