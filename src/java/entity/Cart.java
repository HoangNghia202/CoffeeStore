/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import dao.MenuDao;
import dao.UserDao;

/**
 *
 * @author ASUS
 */
public class Cart {
    private Menu menu;
    private User user;
    private int quantity;
    
    

    public Cart(int idItem, int idUser, int quantity) {
        UserDao userDao;
         MenuDao menuDao;
        userDao= new UserDao();
        for (User user : userDao.getListUser()) {
            if (user.getIdUser()== idUser) {
                this.user=user;
                break;
            }
        }
        menuDao = new MenuDao();
        for (Menu menu : menuDao.getListMenu()) {
            if (menu.getId()==idItem) {
                this.menu=menu;
            }
        }
        this.quantity = quantity;
    }

    public Cart() {
    }
    

    public String getItemName() {
        return menu.getName();
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public float getItemPrice(){
        return this.menu.getPrice();
    }
    
    public int getItemId(){
        return menu.getId();
    }
    
    public String getItemImg(){
        return  menu.getImgLink();
    }

    @Override
    public String toString() {
        return "Cart{" + "item=" + getItemName() + ", user=" + user.getUserName() +", price:"+getItemPrice()+ ", quantity=" + quantity +", img:"+getItemImg()+ '}';
    }
    
    
}
