/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;

/**
 *
 * @author MrDuc
 * Lớp thực thể phòng chiếu: Mã phòng, tên phòng, số lượng ghế, loại phòng, mô tả.
 */
public class PhongChieu {
    private String maPhong;
    private String tenPhong;
    private int soGhe;
    private String loaiPhong;
    private String moTa;

    public PhongChieu() {
    }

    public PhongChieu(String maPhong, String tenPhong, int soGhe,String loaiPhong, String moTa) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.soGhe = soGhe;
        this.loaiPhong = loaiPhong;
        this.moTa = moTa;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "PhongChieu{" + "maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", soGhe=" + soGhe + ", loaiPhong=" + loaiPhong + ", moTa=" + moTa + '}';
    }


    
    public Vector<String> getObject(){
        Vector<String> v = new Vector<>();
        v.add(maPhong + "");
        v.add(tenPhong);
        v.add(soGhe + "");
        v.add(loaiPhong + "");
        v.add (moTa);
        return v;
    }
    
}
