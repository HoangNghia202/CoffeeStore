/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DBContext implements DatabaseInfor{

    public DBContext() {
    }
    
    public  Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn=DriverManager.getConnection(urlDB, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
    
    public  void close(Connection conn , PreparedStatement ps, ResultSet rs ) throws SQLException{
        if (rs!=null && !rs.isClosed()) {
            rs.close();
        }
        
        if (ps!=null && !ps.isClosed()) {
            ps.close();
        }
        if (conn!=null && !conn.isClosed()) {
            conn.close();
        }
    }
}
