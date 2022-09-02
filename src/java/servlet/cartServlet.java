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

/**
 *
 * @author ASUS
 */
public class cartServlet extends HttpServlet {

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
            out.println("<title>Servlet cartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cartServlet at " + request.getContextPath() + "</h1>");
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

        int idUser = (Integer) session.getAttribute("IDUSER");
        String action = request.getParameter("action");
        int idItem = Integer.parseInt(request.getParameter("idItem"));
        CartDao cartDao = new CartDao();
        List<Cart> list = (ArrayList<Cart>) session.getAttribute("LISTITEM");
//        for (Cart cart : list) {
//             if (cart.getItemId()==idItem) {
//                list.remove(cart);
//            }
//        }
        if (action.equals("subtract")) {

            int index = checkExistItem(list, idItem);
            int oldQuan = list.get(index).getQuantity();

            if (oldQuan > 1) {
                Cart newCart = new Cart(idItem, idUser, oldQuan  -1);
                list.set(index, newCart);
                cartDao.updateDB(newCart);
                session.setAttribute("LISTITEM", list);
                response.sendRedirect("cart.jsp");
            } else {
                response.sendRedirect("cart.jsp");
            }
        }

        switch (action) {
            case "delete":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getItemId() == idItem) {
                        list.remove(list.get(i));
                    }

                }
                session.setAttribute("LISTITEM", list);
                cartDao.deleteItem(idUser, idItem);
                request.getRequestDispatcher("cart.jsp").forward(request, response);
                break;

            case "add":
                int index = checkExistItem(list, idItem);
                int oldQuan = list.get(index).getQuantity();
                Cart newCart = new Cart(idItem, idUser, oldQuan + 1);
                list.set(index, newCart);
                cartDao.updateDB(newCart);
                session.setAttribute("LISTITEM", list);
                response.sendRedirect("cart.jsp");
                break;

        }

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
        request.getRequestDispatcher("cart.jsp").forward(request, response);
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
