/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author studentadmin
 */
public class OrderPlaced extends HttpServlet {

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
         
        HttpSession session=request.getSession();
        if(session.getAttribute("page").toString().equals("Customer")){
           Cookie cname=new Cookie("name",request.getParameter("cname"));
           Cookie cadd=new Cookie("add",request.getParameter("cadd"));
           cname.setMaxAge(60*60*24*30);
           cadd.setMaxAge(60*60*24*30);
           
           response.addCookie(cname);
           response.addCookie(cadd);
           
           session.setAttribute("cname",request.getParameter("cname"));
           session.setAttribute("cadd",request.getParameter("cadd"));
        }
      
        else if(session.getAttribute("page").toString().equals("order")){
             
         
        } 
      
      
      
      
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderPlaced</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Name of the Customer : " +session.getAttribute("cname") + "</h1>");
            out.println("<h1>Address of the Customer :" +session.getAttribute("cadd") + "</h1>");
            out.println("<h1>Amount of the Order :" +session.getAttribute("amount") + "</h1>");
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
