/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecom.servlets;

import com.ecom.entities.User;
import com.ecom.helper.ConnectionProvider;
import com.ecom.helper.Message;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");

            String email = request.getParameter("user_email");
            String pass = request.getParameter("user_pass");
            try {
                String query = "select * from user where uEmail= ? and uPass =?";

                Connection con = ConnectionProvider.createConnection();

                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, email);
                pstmt.setString(2, pass);

                ResultSet set = pstmt.executeQuery();
                if (set.next()) {

                    //login success..
                    int uId = set.getInt("uId");
                    String uName = set.getString("uName");
                    String uPass = set.getString("uPass");
                    String uEmail = set.getString("uEmail");
                    String uPic = set.getString("uPic");
                    String uAbout = set.getString("uAbout");
                    String uType = set.getString("uType");

                    User user = new User(uId, uName, uPass, uEmail, uPic, uAbout, uType);

                    HttpSession s = request.getSession();

                    s.setAttribute("current", user);

                    if (user.getuType().equals("admin")) {
                        //admin redirect

                        response.sendRedirect("admin-profile.jsp");
                    } else {
                        //normal redirect
                        response.sendRedirect("normal-profile.jsp");
                    }

                } else {
                    //error

                    Message msg = new Message("Invalid Detail ! try with another", "error");

                    HttpSession s = request.getSession();

                    s.setAttribute("my_msg", msg);
                    response.sendRedirect("login_page.jsp");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

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
