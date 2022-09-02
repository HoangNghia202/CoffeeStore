/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.CartDao;
import dao.MenuDao;
import entity.Cart;
import entity.Menu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.smartcardio.Card;
import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author ASUS
 */
public class ShopServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShopServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShopServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        MenuDao menuDao = new MenuDao();
        List<Menu> listMenu = menuDao.getListMenu();
        List<Menu> listCoffees = new ArrayList<>();
        List<Menu> listDrinks = new ArrayList<>();
        List<Menu> listDesserts = new ArrayList<>();
        for (Menu menu : listMenu) {
            if (menu.getType().equals("coffee")) {
                listCoffees.add(menu);
            } else if (menu.getType().equals("drink")) {
                listDrinks.add(menu);
            } else if (menu.getType().equals("desserts")) {
                listDesserts.add(menu);
            }
        }
        session.setAttribute("LISTCOFFEES", listCoffees);
        session.setAttribute("LISTDRINKS", listDrinks);
        session.setAttribute("LISTDESSERTS", listDesserts);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idItem = Integer.parseInt(request.getParameter("id-item"));
        MenuDao menuDao = new MenuDao();
        CartDao cartDao = new CartDao();
        List<Menu> menu = menuDao.getListMenu();
//        Menu item = null;

//        for (Menu menu1 : menu) {
//            if (menu1.getId()==idItem) {
//               item= menu1;
//            }
//        }
      
        int idUSer = (int) session.getAttribute("IDUSER");
        if (session.getAttribute("LISTITEM") == null) {
            List<Cart> listItem = new ArrayList<>();
            listItem = cartDao.getListCartsOfUser(idUSer);
            if (checkExistItem(listItem, idItem) == -1) {
                Cart cart = new Cart(idItem, idUSer, 1);
                listItem.add(cart);
                cartDao.addCartToDB(cart);
            } else {
                int index = checkExistItem(listItem, idItem);
                int oldQuan = listItem.get(index).getQuantity();
                listItem.get(index).setQuantity(oldQuan + 1);
                cartDao.updateDB(listItem.get(index));
            }
            float sumPrice = 0;
            for (Cart cart : listItem) {
                sumPrice= sumPrice+cart.getItemPrice();
            }
            session.setAttribute("SUMPRICE", sumPrice);
            session.setAttribute("LISTITEM", listItem);
        } else {
            List<Cart> list = (ArrayList<Cart>) session.getAttribute("LISTITEM");
            if (checkExistItem(list, idItem) == -1) {
                Cart cart = new Cart(idItem, idUSer, 1);
                list.add(cart);
                cartDao.addCartToDB(cart);
            } else {
                int index = checkExistItem(list, idItem);
                int oldQuan = list.get(index).getQuantity();
                Cart newCart = new  Cart(idItem, idUSer, oldQuan+1);
                list.set(index, newCart);
                cartDao.updateDB(newCart);
            }
             float sumPrice = 0;
            for (Cart cart : list) {
                sumPrice= sumPrice+cart.getItemPrice();
            }
            session.setAttribute("SUMPRICE", sumPrice);
            session.setAttribute("LISTITEM", list);
        }
        request.getRequestDispatcher("shop.jsp").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public int checkExistItem(List<Cart> list, int idItem) {
        for (Cart cart : list) {
            if (cart.getItemId() == idItem) {
                return list.indexOf(cart);
            }
        }
        return -1;
    }

}
