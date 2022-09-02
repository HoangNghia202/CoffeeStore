/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.AdminDAO;
import entity.Menu;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.runtime.regexp.joni.constants.CCSTATE;

/**
 *
 * @author ASUS
 */
public class editmenuServlet extends HttpServlet {

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
            out.println("<title>Servlet editmenuServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editmenuServlet at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        if (action.equals("Delete")) {
           String type= request.getParameter("type");
           String name = request.getParameter("name");
           AdminDAO adao= new AdminDAO();
            if (adao.deleteItemInMenu(name, type)) {
                response.sendRedirect("./pages/edit-menu.jsp?mess=Successfull");
            }else{
             response.sendRedirect("./pages/edit-menu.jsp?mess=False");
            }
           
        } else if (action.equals("Add Item")) {
            String type= request.getParameter("type");
           String name = request.getParameter("name");
           String des = request.getParameter("describe");
           float price = Float.parseFloat(request.getParameter("price"));
           String image = request.getParameter("image");
         image=image.substring(1, image.length()-1);
             AdminDAO adao= new AdminDAO();
             adao.addItemToMenu(new Menu(type, name, des, price, image));
             response.sendRedirect("./pages/edit-menu.jsp?mess=Successful");
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
        processRequest(request, response);
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
