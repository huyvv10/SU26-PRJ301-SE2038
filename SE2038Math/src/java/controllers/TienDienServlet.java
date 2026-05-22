/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author VU VAN HUY
 */
public class TienDienServlet extends HttpServlet {

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
        String numKwh = request.getParameter("kwh");
        String err = "";
        double rs = 0;
        if (numKwh.isEmpty()) {
            err += "Nhập số kwh điện đã tiêu thụ.";
        } else {
            try {
                int n = Integer.parseInt(numKwh);
                if (n <= 100) {
                    rs = n * 1984;
                } else if (n <= 200) {
                    rs = 100 * 1984 + (n - 100) * 2380;
                } else if (n <= 400) {
                    rs = 100 * 1984 + 100 * 2380 + (n - 200) * 2998;
                } else if (n <= 700) {
                    rs = 100 * 1984 + 100 * 2380 + 200 * 2998 + (n - 400) * 3571;
                } else {
                    rs = 100 * 1984 + 100 * 2380 + 200 * 2998 + 300 * 3571 + (n - 700) * 3967;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TienDienServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (!err.isEmpty()) {
                out.println("<h1>" + err + "</h1>");
            } else {
                out.println("<table border='0'>");
                out.println("<tr>");
                out.println("<td>Tiền điện tiêu thụ</td>");
                out.println("<td>" + rs + "</td>");
                out.println("</tr>");
                out.println("<tr><td>Thuế VAT</td>");
                out.println("<td>" + rs * 0.08 + "</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Tổng tiền phải trả</td>");
                out.println("<td>" + rs * 1.08 + "</td>");
                out.println("</tr>");
                out.println("</table>");
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
//        processRequest(request, response);
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
