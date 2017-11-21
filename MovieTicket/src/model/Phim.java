/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author MrDuc 
 * Lớp thực thể phim gồm các thuộc tính: mã phim, tên phim, thể loại, đạo diễn, ngày khởi chiếu, thời lượng
 * thoiLuong
 */
public class Phim {

    private String maPhim;
    private String tenPhim;
    private String theLoai;
    private String daoDien;
    private String ngayKhoiChieu;
    private int thoiLuong;

    public Phim() {
    }

    public Phim(String maPhim, String tenPhim, String theLoai, String daoDien, String ngayKhoiChieu, int thoiLuong) {
        this.maPhim = maPhim;
        this.tenPhim = tenPhim;
        this.theLoai = theLoai;
        this.daoDien = daoDien;
        this.ngayKhoiChieu = ngayKhoiChieu;
        this.thoiLuong = thoiLuong;
    }

    public void setMaPhim(String maPhim) {
        this.maPhim = maPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public void setNgayKhoiChieu(String ngayKhoiChieu) {
        this.ngayKhoiChieu = ngayKhoiChieu;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getMaPhim() {
        return maPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public String getNgayKhoiChieu() {
        return ngayKhoiChieu;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    @Override
    public String toString() {
        return "Phim{" + "maPhim=" + maPhim + ", tenPhim=" + tenPhim + ", theLoai=" + theLoai + ", daoDien=" + daoDien + ", ngayKhoiChieu=" + ngayKhoiChieu + ", thoiLuong=" + thoiLuong + '}';
    }

    public Vector<String> getObject() {
        Vector<String> v = new Vector<>();
        v.add(maPhim + "");
        v.add(tenPhim);
        v.add(theLoai);
        v.add(daoDien);
        v.add(ngayKhoiChieu);
        v.add(thoiLuong + "");
        return v;
    }
}
