/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Phim;
import support.OpenDB;

/**
 *
 * @author MrDuc 
 * Thực hiệc các thao tác quản lý phim với cơ sở dữ liệu Các thao tác gồm:
 * thêm, sửa, xóa, lấy về danh sách phim, tìm kiếm: theo tên phim, tên
 * đạo diễn, thể loại.
 */
public class PhimDAO {

    private Connection cnn;
    PreparedStatement pr = null;
    ResultSet rs = null;

    /*Hàm khởi tạo mặc định*/
    public PhimDAO() {
        cnn = OpenDB.open();
    }

    /*Hàm lấy về tất cả danh sách phim trong cơ sở dữ liệu*/
    public Vector<Phim> danhSachPhim() {
        Vector<Phim> v = new Vector<>();
        try {
            String sql = "Select * from tbl_phim";
            pr = cnn.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                Phim phim = new Phim(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6));
                v.add(phim);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    /*Hàm thêm 1 phim vào cơ sở dữ liệu, đầu vào là 1 phim*/
    public boolean themPhim(Phim phim) {

        /*Sử dụng câu truy vấn để tìm mã phim trùng*/
        String sql = "Select * from tbl_phim where maPhim = ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, phim.getMaPhim());
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {    //Nếu rs có thể next đc thì chứng tỏ mã phim đã bị trùng
                return false;
            } else {            //Mã phim này chưa có và có thể thêm vào csdl
                sql = "Insert Into tbl_phim(maPhim, tenPhim, theLoai, daoDien, ngayKhoiChieu, thoiLuong) Values (?,?,?,?,?,?)";
                pr = cnn.prepareStatement(sql);
                pr.setString(1, phim.getMaPhim());
                pr.setString(2, phim.getTenPhim());
                pr.setString(3, phim.getTheLoai());
                pr.setString(4, phim.getDaoDien());
                pr.setString(5, phim.getNgayKhoiChieu());
                pr.setInt(6, phim.getThoiLuong());
                int t = pr.executeUpdate();
                if (t > 0) {
                    return true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /*Hàm sửa phim, đầu vào là mã phim muốn sửa, và 1 phim thay thế*/
    public boolean suaPhim(String key, Phim phim) {
        String sql = "Update tbl_phim Set tenPhim = ?, theLoai = ?, "
                + "daoDien = ?, ngayKhoiChieu = ?, thoiLuong = ? Where maPhim = ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, phim.getTenPhim());
            pr.setString(2, phim.getTheLoai());
            pr.setString(3, phim.getDaoDien());
            pr.setString(4, phim.getNgayKhoiChieu());
            pr.setInt(5, phim.getThoiLuong());
            pr.setString(6, key);
            int t = pr.executeUpdate();
            if (t > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*Hàm xóa phim, đầu vào là mã phim muốn xóa*/
    public boolean xoaPhim(String key) {
        String sql = "Delete From tbl_phim Where maPhim = ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, key);
            int t = pr.executeUpdate();
            if (t > 0) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /*Hàm tìm kiếm phim, đầu vào là 1 từ =>> tất cả những phim có chứa từ đó*/
    public Vector<Phim> timKiemPhim(String key) {
        Vector<Phim> v = new Vector<>();
        String sql = "Select * From tbl_phim";

        try {
            pr = cnn.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                Phim phim = new Phim(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6));
                if (phim.toString().contains(key)) {
                    v.add(phim);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    /*Tìm kiếm theo tên phim*/
    public Vector<Phim> timKiemTheoTenPhim(String key) {
        Vector<Phim> v = new Vector<>();
        String sql = "Select * from tbl_phim Where tenPhim Like ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, "%" + key + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                Phim phim = new Phim(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6));
                v.add(phim);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    /*Tìm kiếm theo mã phim*/
    public Vector<Phim> timKiemTheoMaPhim(String key) {
        Vector<Phim> v = new Vector<>();
        String sql = "Select * from tbl_phim Where maPhim Like ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, "%" + key + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                Phim phim = new Phim(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6));
                v.add(phim);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    /*Tìm kiếm theo thể loại phim*/
    public Vector<Phim> timKiemTheoLoaiPhim(String key) {
        Vector<Phim> v = new Vector<>();
        String sql = "Select * from tbl_phim Where theLoai Like ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, "%" + key + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                Phim phim = new Phim(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6));
                v.add(phim);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    public Vector<Phim> timKiemTheoDaoDien(String key) {
        Vector<Phim> v = new Vector<>();
        String sql = "Select * from tbl_phim Where daoDien Like ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, "%" + key + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                Phim phim = new Phim(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6));
                v.add(phim);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }
}
