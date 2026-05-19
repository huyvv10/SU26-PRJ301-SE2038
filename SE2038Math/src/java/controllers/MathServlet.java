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
public class MathServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String op = request.getParameter("op");
        String rs="";
        boolean flag=false;
        if (num1.isEmpty() || num2.isEmpty()){
            rs+="Number 1 and number 2 must not be empty.";
        } else {
            try {
                flag=true;
                double n1, n2;
                n1=Double.parseDouble(num1);
                n2=Double.parseDouble(num2);
                switch (op){
                    case "+":
                        rs+=n1+n2; break;
                    case "-":
                        rs+=n1-n2; break;
                    case "*":
                        rs+=n1*n2; break;
                    case "/":
                        if (n2!=0)
                            rs+=n1/n2; 
                        else{
                            flag=false;
                            rs+="Number 2 must not be zero!";
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MathServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            if (flag)
                out.println("<h1> Result of: " + num1 +" "+op+" " 
                        + num2 + " = "+ rs + "</h1>");
            else
                out.println(rs);
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("index.html")
                .forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
