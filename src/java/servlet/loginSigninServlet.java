/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.CartDao;
import dao.MenuDao;
import dao.UserDao;
import entity.Cart;
import entity.Menu;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author ASUS
 */
//@WebServlet("")
public class loginSigninServlet extends HttpServlet {

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
            out.println("<title>Servlet loginSigninServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginSigninServlet at " + request.getContextPath() + "</h1>");
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

        if (session.getAttribute("IDUSER") == null) {
            request.getRequestDispatcher("loginAndSignin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
        String email = request.getParameter("email-log");
        String password = request.getParameter("password-log");
        UserDao userDao = new UserDao();
        if (userDao.checkLogin(email, password)) {
            User user = userDao.getUserfromEmail(email);
            session.setAttribute("IDUSER", user.getIdUser());
            CartDao cartDao = new CartDao();
            List<Cart> listItem = cartDao.getListCartsOfUser(user.getIdUser());
            session.setAttribute("INUSER", user);
            session.setAttribute("LISTITEM", listItem);
            Cookie ckUserEmail = new Cookie("userEmail", email);
            Cookie ckPassword = new Cookie("password", password);
            ckUserEmail.setMaxAge(60 * 60 * 24 * 7);
            ckUserEmail.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(ckPassword);
            response.addCookie(ckUserEmail);

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
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            String message = "Wrong email or password.";
            request.setAttribute("ERROR_LOGIN", message);
            request.getRequestDispatcher("loginAndSignin.jsp").forward(request, response);
        }
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

}
