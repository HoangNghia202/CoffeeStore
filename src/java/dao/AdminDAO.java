/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.javafx.font.FontConstants;
import dbConnect.DBContext;
import entity.Admin;
import entity.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class AdminDAO {

    private static DBContext db;

    public AdminDAO() {
        db = new DBContext();
    }

    public List<Admin> getListAdmin() {
        List<Admin> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT TOP (1000) [Id]\n"
                + "      ,[AminName]\n"
                + "      ,[password]\n"
                + "      ,[email]\n"
                + "  FROM [Asignment].[dbo].[Admin]";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2).trim();
                String pass = rs.getString(3).trim();
                String email = rs.getString(4).trim();
                list.add(new Admin(id, name, pass, email));

            }
        } catch (Exception e) {
        } finally {
            try {
                db.close(conn, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public String checkSignUp(String name, String email, String pass) {
        List<Admin> list = getListAdmin();
        for (Admin admin : list) {
            if (admin.getEmail().equals(email)) {
                return "err-email";
            }
            if (admin.getAdName().equals(name)) {
                return "err-name";
            }
        }

        return "true";
    }

    public void addNewAdmin(Admin admin) {
        List<Admin> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "insert into admin values(?,?,?)";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, admin.getAdName());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getEmail());
            ps.execute();
        } catch (Exception e) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Admin getAdmin(String email) {
        List<Admin> list = getListAdmin();
        for (Admin admin : list) {
            if (admin.getEmail().equals(email)) {
                return admin;
            }
        }
        return null;
    }

    public boolean checkLogin(Admin admin) {
        for (Admin ad : getListAdmin()) {
            if (ad.getEmail().equals(admin.getEmail()) && ad.getPassword().equals(admin.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void addItemToMenu(Menu menu) {
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "insert into menu values(?,?,?,?,?)";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, menu.getType());
            ps.setString(2, menu.getName());
            ps.setString(3, menu.getDescribe());
            ps.setFloat(4, menu.getPrice());
            ps.setString(5, menu.getImgLink());
            ps.execute();
        } catch (Exception e) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public boolean deleteItemInMenu(String name, String type) {
//        Menu menu= new MenuDao().getMenuByname(name);
//         if (menu==null) {
//            return false;
//        }
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "delete from menu where type=? and name=?";
        try {

            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, type);
            ps.setString(2, name);
            ps.execute();

        } catch (Exception e) {

        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
}
