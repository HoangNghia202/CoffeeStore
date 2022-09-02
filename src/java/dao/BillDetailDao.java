/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbConnect.DBContext;
import entity.Bill;
import entity.BillDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ASUS
 */
public class BillDetailDao {
     private final DBContext db;

    public BillDetailDao() {
        db = new DBContext();
    }
    
     public void addBillDetailToData(BillDetail billDetail){
          Connection conn = null;
        PreparedStatement ps = null;

        String query = "Insert into billDetail values(?,?,?,?,?)";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1,billDetail.getIdBill());
            ps.setInt(2, billDetail.getIdMenu());
            ps.setFloat(3, billDetail.getPrice());
            ps.setInt(4, billDetail.getQuantity());
            ps.setFloat(5, billDetail.getSumPrice());
            ps.execute();

        } catch (Exception e) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CartDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
