/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Phim;
import model.PhongChieu;
import support.OpenDB;

/**
 *
 * @author MrDuc Các chức năng: thêm, sửa, xóa, tìm kiếm phòng
 */
public class PhongDAO {

    private Connection cnn;
    PreparedStatement pr = null;
    ResultSet rs = null;

    public PhongDAO() {
        cnn = OpenDB.open();
    }

    /*Hàm lấy về tất cả danh sách phòng chiếu trong cơ sở dữ liệu*/
    public Vector<PhongChieu> danhSachPhong() {
        Vector<PhongChieu> v = new Vector<>();
        try {
            String sql = "Select * from tbl_phong_chieu";
            pr = cnn.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                PhongChieu phongChieu = new PhongChieu(rs.getString(1), rs.getString(2),
                        Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5));
                v.add(phongChieu);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    /*Hàm thêm 1 phòng chiếu vào cơ sở dữ liệu, đầu vào là 1 phòng chiếu*/
    public boolean themPhong(PhongChieu phongChieu) {
        String sql = "Select * from tbl_phong_chieu where maPhong = ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, phongChieu.getMaPhong());
            ResultSet exeQuery = pr.executeQuery();
            if (exeQuery.next()) {  //Kiểm tra xem mã phòng có bị trùng không?
                return false;
            } else {                //Mã phòng không bị trùng và bắt đầu thêm vào csdl
                sql = "Insert Into tbl_phong_chieu(maPhong, tenPhong, soGhe, loaiPhong, moTa) Values (?,?,?,?,?)";
                pr = cnn.prepareStatement(sql);
                pr.setString(1, phongChieu.getMaPhong());
                pr.setString(2, phongChieu.getTenPhong());
                pr.setInt(3, phongChieu.getSoGhe());
                pr.setString(4, phongChieu.getLoaiPhong());
                pr.setString(5, phongChieu.getMoTa());
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

    /*Hàm sửa phòng chiếu, đầu vào là mã phong chiếu muốn sửa, và 1 phòng chiếu thay thế*/
    public boolean suaPhong(String key, PhongChieu phongChieu) {
        String sql = "Update tbl_phong_chieu Set tenPhong = ?, soGhe = ?, "
                + "loaiPhong = ?, moTa = ? Where maPhong = ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, phongChieu.getTenPhong());
            pr.setInt(2, phongChieu.getSoGhe());
            pr.setString(3, phongChieu.getLoaiPhong());
            pr.setString(4, phongChieu.getMoTa());
            pr.setString(5, key);
            int t = pr.executeUpdate();
            if (t > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*Hàm xóa phòng chiếu, đầu vào là mã phòng muốn xóa*/
    public boolean xoaPhongChieu(String key) {
        String sql = "Delete From tbl_phong_chieu Where maPhong = ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, key);
            int t = pr.executeUpdate();
            if (t > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*Hàm tìm kiếm phòng, đầu vào là 1 từ =>> tất cả những phim có chứa từ đó*/
    public Vector<PhongChieu> timKiemPhong(String key) {
        Vector<PhongChieu> v = new Vector<>();
        String sql = "Select * From tbl_phong_chieu";

        try {
            pr = cnn.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                PhongChieu phongChieu = new PhongChieu(rs.getString(1), rs.getString(2),
                        Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5));
                if (phongChieu.toString().contains(key)) {
                    v.add(phongChieu);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    /*Tìm kiếm theo mã phòng*/
    public Vector<PhongChieu> timKiemTheoMaPhong(String key) {
        Vector<PhongChieu> v = new Vector<>();
        String sql = "Select * from tbl_phong_chieu Where maPhong Like ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, "%" + key + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                PhongChieu phongChieu = new PhongChieu(rs.getString(1), rs.getString(2),
                        Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5));
                v.add(phongChieu);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    /*Tìm kiếm theo tên phòng*/
    public Vector<PhongChieu> timKiemTheoTenPhong(String key) {
        Vector<PhongChieu> v = new Vector<>();
        String sql = "Select * from tbl_phong_chieu Where tenPhong Like ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, "%" + key + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                PhongChieu phongChieu = new PhongChieu(rs.getString(1), rs.getString(2),
                        Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5));
                v.add(phongChieu);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    /*Tìm kiếm theo loại phòng*/
    public Vector<PhongChieu> timKiemTheoLoaiPhong(String key) {
        Vector<PhongChieu> v = new Vector<>();
        String sql = "Select * from tbl_phong_chieu Where loaiPhong Like ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, "%" + key + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                PhongChieu phongChieu = new PhongChieu(rs.getString(1), rs.getString(2),
                        Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5));
                v.add(phongChieu);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    /*Tìm kiếm theo số lượng ghế*/
    public Vector<PhongChieu> timKiemTheoSoGhe(String key) {
        Vector<PhongChieu> v = new Vector<>();
        String sql = "Select * from tbl_phong_chieu Where soGhe = ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setInt(1, Integer.parseInt(key));
            rs = pr.executeQuery();
            while (rs.next()) {
                PhongChieu phongChieu = new PhongChieu(rs.getString(1), rs.getString(2),
                        Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5));
                v.add(phongChieu);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }
}
