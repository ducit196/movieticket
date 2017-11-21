/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MrDuc
 */
public class OpenDB {

    public static String url = "jdbc:mysql://localhost/banvexemphim";
    public static String driver = "com.mysql.jdbc.Driver";
    public static String user = "root";
    public static String pass = "1234";
    
        public static  Connection open() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OpenDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OpenDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void close(ResultSet rs, Statement st, Connection cnn) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OpenDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (st != null && !st.isClosed()) {
                st.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OpenDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (cnn != null && !cnn.isClosed()) {
                cnn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OpenDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

