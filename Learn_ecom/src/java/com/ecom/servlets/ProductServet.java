/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecom.servlets;

import com.ecom.helper.ConnectionProvider;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author pc
 */
@MultipartConfig
public class ProductServet extends HttpServlet {

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
            out.println("<title>Servlet ProductServet</title>");
            out.println("</head>");
            out.println("<body>");
            String op = request.getParameter("operation");

            if (op.equals("add_product")) {
                //add product
//                out.print("inside if");
                String pname = request.getParameter("p_name");
                String pdesc = request.getParameter("p_desc");
                int pprice = Integer.parseInt(request.getParameter("p_price"));
                int pquantity = Integer.parseInt(request.getParameter("p_quantity"));
                Part image = request.getPart("p_pic");

                int pdiscount = Integer.parseInt(request.getParameter("p_discount"));
                int cid = Integer.parseInt(request.getParameter("p_cat"));

                try {
                    String query = "insert into products(pTitle,pDesc,pPrice,pQuantity,pPic,pDiscount,cId) values(?,?,?,?,?,?,?)";

                    Connection con = ConnectionProvider.createConnection();

                    PreparedStatement pstmt = con.prepareStatement(query);

                    pstmt.setString(1, pname);
                    pstmt.setString(2, pdesc);
                    pstmt.setDouble(3, pprice);

                    pstmt.setInt(4, pquantity);
                    pstmt.setString(5, image.getSubmittedFileName());

                    pstmt.setInt(6, pdiscount);

                    pstmt.setInt(7, cid);

                    pstmt.executeUpdate();

                    //uploading...
                    String path = request.getRealPath("/") + "\\" + "img\\" + image.getSubmittedFileName();
                    out.print(path);

                    //read...request image
                    InputStream is = image.getInputStream();
                    byte b[] = new byte[is.available()];

                    is.read(b);

                    //write path:
                    FileOutputStream fos = new FileOutputStream(path);

                    fos.write(b);

                    fos.close();

                    out.println("success");

                } catch (Exception e) {
                    e.printStackTrace();
                }

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
