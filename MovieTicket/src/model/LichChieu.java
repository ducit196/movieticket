/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author MrDuc
 */
public class LichChieu {
    private String maLichChieu;
    private Phim phim;
    private PhongChieu phong;
    private String ngayChieu;
    private String gioChieu;

    public LichChieu() {
    }

    public String getMaLichChieu() {
        return maLichChieu;
    }

    public Phim getPhim() {
        return phim;
    }

    public PhongChieu getPhong() {
        return phong;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public String getGioChieu() {
        return gioChieu;
    }

    public void setMaLichChieu(String maLichChieu) {
        this.maLichChieu = maLichChieu;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    public void setPhong(PhongChieu phong) {
        this.phong = phong;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public void setGioChieu(String gioChieu) {
        this.gioChieu = gioChieu;
    }

        public Vector<String> getObject(){
        Vector<String> v = new Vector<>();
        v.add(maLichChieu + "");
        v.add(phim.getTenPhim());
        v.add(phim.getThoiLuong() + "");
        v.add(phong.getTenPhong() + "");
        v.add (phong.getSoGhe() + "");
        v.add(ngayChieu);
        v.add(gioChieu);
        return v;
    }
}
