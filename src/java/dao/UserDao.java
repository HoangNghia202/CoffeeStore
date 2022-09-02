/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbConnect.DBContext;
import entity.User;
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
public class UserDao {

    private final DBContext db;

    public UserDao() {
        db = new DBContext();
    }

    public List<User> getListUser() {
        List<User> list = new ArrayList<>();
        String query = "SELECT TOP (1000) [id]\n"
                + "      ,[firstName]\n"
                + "      ,[lastName]\n"
                + "      ,[streetAddr]\n"
                + "      ,[town]\n"
                + "      ,[city]\n"
                + "      ,[phone]\n"
                + "      ,[email]\n"
                + "      ,[userName]\n"
                + "      ,[passWord]\n"
                + "  FROM [Asignment].[dbo].[userInfor]";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String streetAddr = rs.getString(4);
                String town = rs.getString(5);
                String city = rs.getString(6);
                int phoneNum = rs.getInt(7);
                String email = rs.getString(8).trim();
                String username = rs.getString(9).trim();
                String password = rs.getString(10).trim();
                list.add(new User(id, firstName, lastName, streetAddr, town, city, phoneNum, email, username, password));
            }

        } catch (Exception e) {

        } finally {
            try {
                db.close(conn, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public boolean checkLogin(String email, String passWord) {
        List<User> list = getListUser();
        for (User user : list) {
            if (email.equals(user.getEmail()) && passWord.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
    
    

    public String checkSignUp(User user) {
        List<User> list = getListUser();
        for (User user1 : list) {
            if (user.getEmail().equals(user1.getEmail())) {
                return "false(email-same)";
            } else if (user.getUserName().equals(user1.getUserName())) {
                return "false(userName-same)";
            }
        }
        
         return "true";      
    }
    
     public void SignUp(User user) {
      
        String query = "  insert into userInfor (firstName, lastName, streetAddr, town, city, phone, email, userName, passWord) \n"
                + "  values (?, ?, ?, ?, ?, ?,?, ?, ?);\n" 
                ;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getStreetAddress());
            ps.setString(4, user.getTown());
            ps.setString(5, user.getCity());
            ps.setInt(6, user.getPhone());
            ps.setString(7, user.getEmail());
            ps.setString(8, user.getUserName());
            ps.setString(9, user.getPassword());
            ps.execute();
        } catch (Exception e) {
        } finally{
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
    
    
    public User getUserfromEmail(String email){
         List<User> list = getListUser();
         for (User user : list) {
             if (user.getEmail().equals(email)) {
                 return user;
             }
        }
         return null;
     }

}
