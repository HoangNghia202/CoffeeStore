/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.UserDao;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class registerServlet extends HttpServlet {

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
            out.println("<title>Servlet registerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registerServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String fname = request.getParameter("fname-sign");
        String lname = request.getParameter("lname-sign");
        String adress = request.getParameter("address-sign");
        String town = request.getParameter("town-sign");
        String city = request.getParameter("city-sign");
        int phoneNum = Integer.parseInt(request.getParameter("phone-sign"));
        String email = request.getParameter("email-sign");
        String userName = request.getParameter("username-sign");
        String password = request.getParameter("password-sign");
        User newUser = new User(fname, lname, adress, town, city, phoneNum, email, userName, password);
        UserDao userDao = new UserDao();
        String message = userDao.checkSignUp(newUser);
        if (message.equals("true")) {
            userDao.SignUp(newUser);
            request.setAttribute("NEWEMAIL", email);
            request.setAttribute("NEWPASS", password);
            request.getRequestDispatcher("loginAndSignin.jsp").forward(request, response);
        } else {
            if (message.equals("false(email-same)")) {
                message = "*Email has existed!";
               
            } else if (message.equals("false(userName-same)")) {
                message = "*Username has existed!";
                   
            }
            
            request.setAttribute("ERRMESSAGE", message);
            request.setAttribute("USERSIGNUP", newUser);
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
