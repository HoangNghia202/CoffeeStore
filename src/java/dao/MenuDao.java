/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbConnect.DBContext;
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
public class MenuDao {
     private final DBContext db;

    public MenuDao() {
       db= new DBContext();
    }
    
    public List<Menu> getListMenu(){
        List<Menu> list = new ArrayList<>();
        String query ="select * from menu";
        
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        try {
            conn=db.getConnection();
            ps = conn.prepareStatement(query);
            rs= ps.executeQuery();
            while (rs.next()) {                
                int id = rs.getInt(1);
                String type = rs.getString(2);
                String name = rs.getString(3);
                String describe = rs.getNString(4);
                float price = rs.getFloat(5);
                String imgLink = rs.getNString(6);
                list.add(new Menu(id, type, name, describe, price, imgLink));
            }
            
        } catch (Exception e) {
            
        }finally{
            try {
                db.close(conn, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public Menu getMenuByname(String name){
        List<Menu> list = getListMenu();
        for (Menu menu : list) {
            if (menu.getName().equalsIgnoreCase(name)) {
                return menu;
            }
        }
        return null;
    }
    
    
}
