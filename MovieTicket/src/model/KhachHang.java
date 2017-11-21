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
 */
class KhachHang {

    private String maKhachHang;
    private String hoTen;
    private String diaChi;
    private String soDT;
    private float diemTichLuy;

    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String hoTen, String diaChi, String soDT, float diemTichLuy) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.diemTichLuy = diemTichLuy;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public float getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public void setDiemTichLuy(float diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }


    public Vector<String> getObject() {
        Vector<String> v = new Vector<>();
        v.add(maKhachHang + "");
        v.add(hoTen);
        v.add(diaChi);
        v.add(soDT);
        v.add(diemTichLuy + "");
        return v;
    }
}
