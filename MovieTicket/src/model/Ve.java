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
 * Lớp thực thể vé bao gồm các thuộc tính: mã vé, lịch chiếu,vị trí, loại vé, giá vé
 */
public class Ve {

    private String maVe;
    private LichChieu lichChieu;
    private String viTri;
    private String loaiVe;
    private float giaVe;

    public Ve() {
    }

    public Ve(String maVe, LichChieu lichChieu, String viTri, String loaiVe, float giaVe) {
        this.maVe = maVe;
        this.lichChieu = lichChieu;
        this.viTri = viTri;
        this.loaiVe = loaiVe;
        this.giaVe = giaVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public void setLichChieu(LichChieu lichChieu) {
        this.lichChieu = lichChieu;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public void setLoaiVe(String loaiVe) {
        this.loaiVe = loaiVe;
    }

    public void setGiaVe(float giaVe) {
        this.giaVe = giaVe;
    }

    public String getMaVe() {
        return maVe;
    }

    public LichChieu getLichChieu() {
        return lichChieu;
    }

    public String getViTri() {
        return viTri;
    }

    public String getLoaiVe() {
        return loaiVe;
    }

    public float getGiaVe() {
        return giaVe;
    }

    public Vector<String> getObject() {
        Vector<String> v = new Vector<>();
        v.add(maVe + "");
        v.add(lichChieu.getPhim().getTenPhim());
        v.add(lichChieu.getPhim().getThoiLuong() + "");
        v.add(lichChieu.getPhong().getTenPhong() + "");
        v.add(lichChieu.getNgayChieu() + "");
        v.add(lichChieu.getGioChieu() + "");
        v.add(giaVe + "");
        v.add(loaiVe);
        return v;
    }
}
