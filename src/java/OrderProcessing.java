/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
public class OrderProcessing extends HttpServlet {
  

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
        
        Integer price=0;
        Integer Flavour=Integer.parseInt(request.getParameter("Flavour"));
        Integer PartyPack=Integer.parseInt(request.getParameter("PartyPack"));
        Integer Quantity=Integer.parseInt(request.getParameter("Quantity"));
        Integer FinalPrice=0;
        HttpSession session=request.getSession();
        
        //Logic for the Price Calculation for Falvour.
        
        switch(Flavour){
            case 1:price+=30;
                   break;
            case 2:price+=40;
                   break;
            case 3:price+=50;
                   break;
            }
                
        //Logic for the Price Calculation for PartyPack.
        
        switch(PartyPack){
            case 1:price+=100;
                   break;
            case 2:price+=150;
                   break;
            case 3:price+=200;
                   break;
            case 4:price+=250;
                   break;
         }
        
        FinalPrice=price*Quantity;
        session.setAttribute("amount",FinalPrice);
        //System.out.println(FinalPrice);
        
       
        //******Logic for the Alreday Existing Cookie
        
         //Step1:Creating the Cookie Constructor
         
          String name=new String();
          String address=new String();
          String empty=new String();//Imp
      
         //Step2:Fteching the Cookie
          
          Cookie ck[]=request.getCookies();
//         
//          Check for the Cookie !=null
          if(ck!=null)
          {
             String CookieName=null;
              
            //Step3:Check for the Cookie Array
               for(Cookie ck1:ck ){
                   
                   CookieName=ck1.getName();
                   //Step 4:Checking the Cookie having the name cname
                   if(CookieName.equals("name")){
                       name=ck1.getValue();
                       session.setAttribute("cname", name);
                   }
                   if(CookieName.equals("add")){
                       address=ck1.getValue();
                       session.setAttribute("cadd",address);
                   }
               }
            }    
         
          //Step5:Chekcing for the no Cookie Name is set Refer the Flow
          if(name.equals(empty)){
             session.setAttribute("page","Customer");
             RequestDispatcher rd=request.getRequestDispatcher("/CustomerDetails.html");
             rd.forward(request, response);
              
          }
          else
           {
              session.setAttribute("page","order");
              RequestDispatcher rd=request.getRequestDispatcher("OrderPlaced");
              rd.forward(request, response);
           }    
           
          
        
        
    
    
    
        
        
        
        
        
        
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderProcessing</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + FinalPrice+ "</h1>");
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
