/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbConnect.DBContext;
import entity.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class BillDao {

    private final DBContext db;

    public BillDao() {
        db = new DBContext();
    }

    public List<Bill> getDayBills(String day) {
        List<Bill> llist = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "   select *\n"
                + "  from bill\n"
                + "  where dayPurchase like ?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, day);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int idUser = rs.getInt(2);
                float totalPrice = rs.getFloat(3);
                String date = rs.getString(4);
                llist.add(new Bill(id, idUser, totalPrice, date));
            }
        } catch (Exception e) {
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BillDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return llist;
    }

    public Bill getLastBillOffUser(int idUser) {
        Bill lastBill = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select top(1) *\n"
                + "from bill\n"
                + "where idUser=?\n"
                + "order by idBill desc";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, idUser);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                int idBill = rs.getInt(1);
                int idUserbill = rs.getInt(2);
                float totalPrice = rs.getFloat(3);
                String dayPerchase = rs.getString(4);
                lastBill = new Bill(idBill, idUserbill, totalPrice, dayPerchase);

            }

        } catch (Exception e) {
        } finally {
            try {
                db.close(conn, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(BillDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lastBill;
    }

    public void addBillToData(Bill bill) {
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "Insert into bill (idUSer, totalPrice, dayPurchase) values(?,?,?)";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, bill.getIdUser());
            ps.setFloat(2, bill.getTotalPrice());
            ps.setString(3, bill.getDatePurchase());
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
