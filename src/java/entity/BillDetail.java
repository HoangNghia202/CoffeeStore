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
public class BillDetail {
   private int idBill;
   private int idMenu;
   private float price;
   private  int quantity;
   private float sumPrice;

    public BillDetail() {
    }

    public BillDetail(int idBill, int idMenu, float price, int quantity, float sumPrice) {
        this.idBill = idBill;
        this.idMenu = idMenu;
        this.price = price;
        this.quantity = quantity;
        this.sumPrice = sumPrice;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(float sumPrice) {
        this.sumPrice = sumPrice;
    }

    @Override
    public String toString() {
        return "BillDetail{" + "idBill=" + idBill + ", idMenu=" + idMenu + ", price=" + price + ", quantity=" + quantity + ", sumPrice=" + sumPrice + '}';
    }
   
   
    
    
}
