/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecom.servlets;

import com.ecom.helper.ConnectionProvider;
import com.ecom.helper.Message;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            String name = request.getParameter("user_name");
            String pass = request.getParameter("user_pass");
            String email = request.getParameter("user_email");
            String about = request.getParameter("user_about");

            try {
                if (!name.isEmpty()) {
                    if (!pass.isEmpty()) {

                        //create connection
                        Connection con = ConnectionProvider.createConnection();
                        String query = "insert into user(uName,uPass,uEmail,uAbout) value (?,?,?,?)";
                        PreparedStatement pstmt = con.prepareStatement(query);

                        pstmt.setString(1, name);
                        pstmt.setString(2, pass);
                        pstmt.setString(3, email);
                        pstmt.setString(4, about);

                        pstmt.executeUpdate();

//                        out.println("Registered Successfully !!");
                        Message msg = new Message("Registeration Successful", "success");

                        HttpSession s = request.getSession();

                        s.setAttribute("my_msg", msg);
                        response.sendRedirect("signup_page.jsp");

                    } else {
                        out.print("<h1>Password is required !!</h1>");

                    }
                } else {
                    Message msg = new Message("Name is required !!", "error");

                    HttpSession s = request.getSession();

                    s.setAttribute("my_msg", msg);
                    response.sendRedirect("signup_page.jsp");
                }

            } catch (Exception e) {
                e.printStackTrace();
                out.println(e.toString());
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
