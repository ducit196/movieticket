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
public class TaiKhoan {
    private int maTK;
    private String userName;
    private String passWord;
    private String hoTen;
    private String diaChi;
    private String soDT;
    private String chucVu;

    public TaiKhoan() {
    }

    public TaiKhoan(int maTK, String userName, String passWord, String hoTen, String diaChi, String soDT, String chucVu) {
        this.maTK = maTK;
        this.userName = userName;
        this.passWord = passWord;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.chucVu = chucVu;
    }

    public int getMaTK() {
        return maTK;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
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

    public String getChucVu() {
        return chucVu;
    }

    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "maTK=" + maTK + ", userName=" + userName + ", passWord=" + passWord + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", soDT=" + soDT + ", chucVu=" + chucVu + '}';
    }
 
    
    
    public Vector<String> getObject(){
        Vector<String> v = new Vector<>();
        v.add(maTK + "");
        v.add(userName + "");
        v.add(passWord + "");
        v.add(hoTen + "");
        v.add(diaChi + "");
        v.add(soDT + "");
        v.add(chucVu + "");
        return v;
    }
}
