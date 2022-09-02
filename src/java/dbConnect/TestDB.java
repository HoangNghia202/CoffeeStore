/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package dbConnect;

import dao.AdminDAO;
import dao.BillDao;
import dao.BillDetailDao;
import dao.CartDao;
import dao.MenuDao;
import dao.UserDao;
import entity.Admin;
import entity.Bill;
import entity.BillDetail;
import entity.Cart;
import entity.Menu;
import entity.User;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class TestDB {

    public static void main(String[] args) {
        UserDao udao = new UserDao();
        List<User> list = udao.getListUser();
        if (list.isEmpty()) {
            System.out.println("em");
        }

        for (User user : list) {
            System.out.println("" + user);
        }

        MenuDao mdao = new MenuDao();

        List<Menu> list1 = mdao.getListMenu();
        for (Menu menu : list1) {
            System.out.println("" + menu);
        }

        System.out.println("========================================\n");
        CartDao cartDao = new CartDao();
//        cartDao.updateDB(new Cart(1, 1, 4));
//        cartDao.deleteItem(1, 2);

        List<Cart> list2 = cartDao.getListCartsOfUser(1);
        for (Cart cart : list2) {
            System.out.println("" + cart);
        }
        
        System.out.println("======================================");
//        
//       BillDao billDao= new BillDao();
//        Bill testBill = new Bill(1, 12);
//        billDao.addBillToData(testBill);
//       Bill lastbill = billDao.getLastBillOffUser(1);
//      
//        System.out.println(""+testBill);
//        System.out.println(""+lastbill);
//               
//        BillDetail billDetail1= new BillDetail(1, 2, 23, 2, 23);
//        BillDetailDao bd = new BillDetailDao();
//        bd.addBillDetailToData(billDetail1);
//        
//       
           List<Admin> list4 = new AdminDAO().getListAdmin();
           for (Admin ad : list4) {
               System.out.println(""+ad);
        }
           
           List<Bill> list5= new BillDao().getDayBills("%07/05%");
           System.out.println(""+list5.toString());
           if (list5.size()==0) {
               System.out.println("000000000000");
        }
           
           
           List<Bill> list6 = new BillDao().getDayBills("");
           
           
      
    }

}
