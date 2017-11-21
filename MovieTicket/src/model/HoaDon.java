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
 * Lớp thực thể hóa đơn bao gồm các thuộc tính:
 * mã hóa đơn, vé, khách hàng, ngày mua, thời gian mua, diểm tích lũy
 *
 */
public class HoaDon {

    private String maHoaDon;
    private Ve ve;
    private KhachHang khachHang;
    private String ngayMua;
    private String thoiGianMua;
    private float diemTichLuy;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, Ve ve, KhachHang khachHang, String ngayMua, String thoiGianMua, float diemTichLuy) {
        this.maHoaDon = maHoaDon;
        this.ve = ve;
        this.khachHang = khachHang;
        this.ngayMua = ngayMua;
        this.thoiGianMua = thoiGianMua;
        this.diemTichLuy = diemTichLuy;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public Ve getVe() {
        return ve;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public String getThoiGianMua() {
        return thoiGianMua;
    }

    public float getDiemTichLuy() {
        return diemTichLuy;
    }


    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setVe(Ve ve) {
        this.ve = ve;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public void setThoiGianMua(String thoiGianMua) {
        this.thoiGianMua = thoiGianMua;
    }

    public void setDiemTichLuy(float diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    
    public Vector<String> getObject() {
        Vector<String> v = new Vector<>();
        v.add(maHoaDon);
        v.add(ve.getLichChieu().getPhim().getTenPhim());
        v.add(ngayMua);
        v.add(thoiGianMua);
        v.add(diemTichLuy + "");
        v.add(ve.getGiaVe() + "");
        return v;
    }
}
