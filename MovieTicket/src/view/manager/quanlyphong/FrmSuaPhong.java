/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.manager.quanlyphong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Phim;
import model.PhongChieu;
import control.PhongDAO;
import javax.swing.UIManager;
import model.TaiKhoan;
import support.BatNgoaiLe;
import view.manager.quanlyphim.*;

/**
 *
 * @author MrDuc
 */
public class FrmSuaPhong extends javax.swing.JFrame {

    private TaiKhoan taiKhoan;
    PhongChieu pc = new PhongChieu();

    /**
     * Creates new form FrmSuaPhim
     */
    public FrmSuaPhong() {
        initComponents();
    }

    public FrmSuaPhong(PhongChieu phongChieu, TaiKhoan tk) {
        initComponents();
        pc = phongChieu;
        taiKhoan = tk;
        setTT();
    }

    /*Set các thuộc tính ban đầu của phòng cần sửa*/
    public void setTT() {
        jtfTenPhong.setText(pc.getTenPhong());
        jtfSoGhe.setText(pc.getSoGhe() + "");
        jcbLoaiPhong.setSelectedItem(pc.getLoaiPhong());
        jtfMoTa.setText(pc.getMoTa());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Content = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfTenPhong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfSoGhe = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcbLoaiPhong = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jtfMoTa = new javax.swing.JTextField();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Footer = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Content.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));
        Content.setLayout(new java.awt.GridLayout(4, 2));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tên phòng");
        Content.add(jLabel2);
        Content.add(jtfTenPhong);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Số ghế");
        Content.add(jLabel3);
        Content.add(jtfSoGhe);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Loại phòng");
        Content.add(jLabel6);

        jcbLoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "Normal", "Vip", "Royal" }));
        Content.add(jcbLoaiPhong);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Mô tả");
        Content.add(jLabel5);
        Content.add(jtfMoTa);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sửa Phòng");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Footer.setBorder(javax.swing.BorderFactory.createTitledBorder("Operation"));
        Footer.setLayout(new java.awt.GridLayout(1, 3));

        jButton1.setText("Sửa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Footer.add(jButton1);

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Footer.add(jButton2);

        jButton3.setText("Trở lại");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Footer.add(jButton3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Footer, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Footer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!BatNgoaiLe.loiString(jtfTenPhong.getText())) {
            JOptionPane.showMessageDialog(null, "Chưa nhập dữ liệu! Mời nhập lại!");
            jtfTenPhong.requestFocus();
            return;
        }
        if (!BatNgoaiLe.loiInt(jtfSoGhe.getText())) {
            JOptionPane.showMessageDialog(null, "Sai định dạng dữ liệu! Mời nhập lại!");
            jtfSoGhe.requestFocus();
            return;
        }
        if (!BatNgoaiLe.loiString(jtfMoTa.getText())) {
            JOptionPane.showMessageDialog(null, "Chưa nhập dữ liệu! Mời nhập lại!");
            jtfMoTa.requestFocus();
            return;
        }
        PhongDAO phongDAO = new PhongDAO();
        int luaChon = JOptionPane.showConfirmDialog(this, "Thông tin phòng\n"
                + "Tên phòng:" + jtfTenPhong.getText() + "\n"
                + "Số ghế:" + jtfSoGhe.getText() + "\n"
                + "Loại phòng: " + jcbLoaiPhong.getSelectedItem().toString() + "\n"
                + "Mô tả: " + jtfMoTa.getText() + "\n");
        if (luaChon == JOptionPane.YES_NO_OPTION) {
            PhongChieu phongChieu = new PhongChieu("", jtfTenPhong.getText(),
                    Integer.parseInt(jtfSoGhe.getText()), jcbLoaiPhong.getSelectedItem().toString(), jtfMoTa.getText());
            boolean check = phongDAO.suaPhong(pc.getMaPhong(), phongChieu);
            if (check == true) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                pc = phongChieu;
            } else {
                JOptionPane.showMessageDialog(null, "Sửa thất bại!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setTT();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new FrmTimKiemSua(taiKhoan).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSuaPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> jcbLoaiPhong;
    private javax.swing.JTextField jtfMoTa;
    private javax.swing.JTextField jtfSoGhe;
    private javax.swing.JTextField jtfTenPhong;
    // End of variables declaration//GEN-END:variables
}
