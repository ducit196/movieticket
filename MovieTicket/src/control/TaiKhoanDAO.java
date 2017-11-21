/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import model.PhongChieu;
import model.TaiKhoan;
import support.OpenDB;

/**
 *
 * @author MrDuc
 * Thực hiện các công việc: thêm, thêm sửa, xóa tài khoản
 */
public class TaiKhoanDAO {

    private Connection cnn;
    PreparedStatement pr = null;
    ResultSet rs = null;

    public TaiKhoanDAO() {
        cnn = OpenDB.open();
    }

    /*Hàm lấy về danh sách các tài khoản có trong csdl*/
    public Vector<TaiKhoan> danhSachTaiKhoan() {
        Vector<TaiKhoan> v = new Vector<>();
        try {
            String sql = "Select * from tbl_tai_khoan";
            pr = cnn.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                v.add(taiKhoan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    /*Hàm thêm 1 tài khoản vào cơ sở dữ liệu, đầu vào là 1 phòng chiếu*/
    public boolean themTaiKhoan(TaiKhoan taiKhoan) {
        String sql = "Select * from tbl_tai_khoan where userName = ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, taiKhoan.getUserName());
            ResultSet exeQuery = pr.executeQuery();
            if (exeQuery.next()) {  //Kiểm tra xem tai khoản có bị trùng không?
                return false;
            } else {                //Tài khoản không bị trùng và bắt đầu thêm vào csdl
                sql = "Insert Into tbl_tai_khoan(userName, passWord, hoTen, diaChi, soDienThoai, chucVu) Values (?,?,?,?,?,?)";
                pr = cnn.prepareStatement(sql);
                pr.setString(1, taiKhoan.getUserName());
                pr.setString(2, taiKhoan.getPassWord());
                pr.setString(3, taiKhoan.getHoTen());
                pr.setString(4, taiKhoan.getDiaChi());
                pr.setString(5, taiKhoan.getSoDT());
                pr.setString(6, taiKhoan.getChucVu());
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

    /*Hàm sửa  tài khoản, đầu vào là mã tài khoản muốn sửa, và 1 phòng chiếu thay thế*/
    public boolean suaTaiKhoan(int key, TaiKhoan taiKhoan) {
        String sql = "Update tbl_tai_khoan Set userName = ?, passWord = ?, "
                + "hoTen = ?, diaChi = ?, soDienThoai = ?, chucVu = ? Where id = ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, taiKhoan.getUserName());
            pr.setString(2, taiKhoan.getPassWord());
            pr.setString(3, taiKhoan.getHoTen());
            pr.setString(4, taiKhoan.getDiaChi());
            pr.setString(5, taiKhoan.getSoDT());
            pr.setString(6, taiKhoan.getChucVu());
            pr.setInt(7, key);
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
    public boolean xoaTaiKhoan(int key) {
        String sql = "Delete From tbl_tai_khoan Where id = ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setInt(1, key);
            int t = pr.executeUpdate();
            if (t > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*Tìm kiếm tài khoản theo tất cả tiêu chí*/
    public Vector<TaiKhoan> timKiemTaiKhoan(String key) {
        Vector<TaiKhoan> v = new Vector<>();
        String sql = "Select * From tbl_tai_khoan";

        try {
            pr = cnn.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                if (taiKhoan.toString().contains(key)) {
                    v.add(taiKhoan);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    /*Tìm kiếm theo userName*/
    public Vector<TaiKhoan> timKiemTheoUserName(String key) {
        Vector<TaiKhoan> v = new Vector<>();
        String sql = "Select * from tbl_tai_khoan Where userName Like ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, "%" + key + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                v.add(taiKhoan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    /*Tìm kiếm theo họ tên*/
    public Vector<TaiKhoan> timKiemTheoHoTen(String key) {
        Vector<TaiKhoan> v = new Vector<>();
        String sql = "Select * from tbl_tai_khoan Where hoTen Like ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, "%" + key + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                v.add(taiKhoan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    /*Tìm kiếm theo địa chỉ*/
    public Vector<TaiKhoan> timKiemTheoDiaChi(String key) {
        Vector<TaiKhoan> v = new Vector<>();
        String sql = "Select * from tbl_tai_khoan Where diaChi Like ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, "%" + key + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                v.add(taiKhoan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    /*Tìm kiếm theo so điện thoại*/
    public Vector<TaiKhoan> timKiemTheoSoDienThoai(String key) {
        Vector<TaiKhoan> v = new Vector<>();
        String sql = "Select * from tbl_tai_khoan Where soDienThoai Like ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, "%" + key + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                v.add(taiKhoan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    /*TÌm kiếm theo chức vụ*/
    public Vector<TaiKhoan> timKiemTheoChucVu(String key) {
        Vector<TaiKhoan> v = new Vector<>();
        String sql = "Select * from tbl_tai_khoan Where chucVu Like ?";
        try {
            pr = cnn.prepareStatement(sql);
            pr.setString(1, "%" + key + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                v.add(taiKhoan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }
}
