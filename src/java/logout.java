/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JOSHI
 */
 
import java.util.Date;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;



public class logout extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false);
         request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/index.html");
       
        
}
}
