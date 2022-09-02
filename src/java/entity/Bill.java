/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ASUS
 */
public class Bill {

    private int idBill;
    private int idUser;
    private float totalPrice;
    private String datePurchase;

    public Bill() {

    }

    public Bill(int idBill, int idUser, float totalPrice, String datePurchase) {
        this.idBill = idBill;
        this.idUser = idUser;
        this.totalPrice = totalPrice;
        this.datePurchase = datePurchase;
    }

    public Bill(int idUser, float totalPrice) {
        this.idUser = idUser;
        this.totalPrice = totalPrice;
        setDatePurchase();
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase() {
        SimpleDateFormat format = new SimpleDateFormat("E, yyyy/MM/dd hh:mm:ss");
        String strDate = format.format(new java.util.Date());
        this.datePurchase = strDate;
    }

    @Override
    public String toString() {
        return "Bill{" + "idBill=" + idBill + ", idUser=" + idUser + ", totalPrice=" + totalPrice + ", datePurchase=" + datePurchase + '}';
    }

}
