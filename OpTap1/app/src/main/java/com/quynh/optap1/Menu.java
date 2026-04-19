package com.quynh.optap1;

public class Menu {
    private String ten;
    private double gia;
    private String moTa;
    private int idAnh;

    public Menu(String ten, double gia, String moTa, int idAnh) {
        this.ten = ten;
        this.gia = gia;
        this.moTa = moTa;
        this.idAnh = idAnh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getIdAnh() {
        return idAnh;
    }

    public void setIdAnh(int idAnh) {
        this.idAnh = idAnh;
    }
}