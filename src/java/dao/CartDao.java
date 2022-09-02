/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbConnect.DBContext;
import entity.Cart;
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
public class CartDao {

    private final DBContext db;

    public CartDao() {
        db = new DBContext();
    }

    public List<Cart> getListCarts() {
        List<Cart> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from cart";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt(1);
                int idItem = rs.getInt(2);
                int quantity = rs.getInt(3);

                list.add(new Cart(idItem, idUser, quantity));

            }

        } catch (Exception e) {
        } finally {
            try {
                db.close(conn, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(CartDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
     public List<Cart> getListCartsOfUser(int idOfUser) {
        List<Cart> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from cart where idUser=?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, idOfUser);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt(1);
                int idItem = rs.getInt(2);
                int quantity = rs.getInt(3);

                list.add(new Cart(idItem, idUser, quantity));

            }

        } catch (Exception e) {
        } finally {
            try {
                db.close(conn, ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(CartDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
     
     


    public void deleteUserCart(int idUser) {
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "delete from cart where idUser=?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, idUser);
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

    public int checkExistItem(int idItem) {
        List<Cart> list = getListCarts();
        for (Cart cart : list) {
            if (cart.getItemId() == idItem) {
                return list.indexOf(cart);
            }
        }
        return -1;
    }

    public void addCartToDB(Cart cart) {
        Connection conn = null;
        PreparedStatement ps = null;
        String query = " insert into cart values (?,?,?);";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cart.getUser().getIdUser());
            ps.setInt(2, cart.getItemId());
            ps.setInt(3, cart.getQuantity());
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

    public void updateDB(Cart cart) {
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "update cart  set quantity=? where idUser=? and idItem=?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cart.getQuantity());
            ps.setInt(2, cart.getUser().getIdUser());
            ps.setInt(3, cart.getItemId());
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
    
    public void deleteItem(int idUser, int idItem){
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "delete from cart where idUser=? and idItem=?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, idUser);
            ps.setInt(2,idItem);
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
