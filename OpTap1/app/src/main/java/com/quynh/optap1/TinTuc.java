package com.quynh.optap1;

public class TinTuc {
    private String tieuDe;
    private String link;
    private String ngayDang;

    public TinTuc(String tieuDe, String link, String ngayDang) {
        this.tieuDe = tieuDe;
        this.link = link;
        this.ngayDang = ngayDang;
    }

    public String getTieuDe() { return tieuDe; }
    public String getLink() { return link; }
    public String getNgayDang() { return ngayDang; }
}