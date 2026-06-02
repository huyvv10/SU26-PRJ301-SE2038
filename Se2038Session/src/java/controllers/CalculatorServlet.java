/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Data;

/**
 *
 * @author VU VAN HUY
 */
@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet {

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
            out.println("<title>Servlet CalculatorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculatorServlet at " + request.getContextPath() + "</h1>");
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
        String strNum1 = request.getParameter("txtNum1");
        String strNum2 = request.getParameter("txtNum2");
        String op = request.getParameter("op");
        String err = "";
        Double n1, n2, rs = 0.0;
        HttpSession session = request.getSession();
        try {
            n1 = Double.parseDouble(strNum1);
            n2 = Double.parseDouble(strNum2);
            switch (op) {
                case "+":
                    rs = n1 + n2;
                    break;
                case "-":
                    rs = n1 - n2;
                    break;
                case "*":
                    rs = n1 * n2;
                    break;
                case "/":
                    if (n2 != 0) {
                        rs = n1 / n2;
                    } else {
                        err = "Number 2 is zero";
                    }
                    break;
            }
            //init a session

            List<Data> lstData;
            if (session.getAttribute("lstData") == null) {
                lstData = new ArrayList<>();
            } else {
                lstData = (List<Data>) session.getAttribute("lstData");
            }
            //Create an Object x to store values
            Data x = new Data(n1, n2, op, rs);
            lstData.add(x);
            //Set attribute to a session 
            session.setAttribute("lstData", lstData);
            session.setAttribute("n1", n1);
            session.setAttribute("n2", n2);
        } catch (NumberFormatException e) {
            err = "You must input number.";
        }
        session.setAttribute("errmess", err);
        request.getRequestDispatcher("calculator.jsp")
                .forward(request, response);
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
