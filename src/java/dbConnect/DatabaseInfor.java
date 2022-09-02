/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnect;

/**
 *
 * @author ASUS
 */
public interface DatabaseInfor {

    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String urlDB = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Asignment;";
    // username va password ni la tuy may. Luc cai dat sql server da co
    String user = "sa";
    String pass = "12345";
}
