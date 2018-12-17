
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JOSHI
 */
public class Wardenlogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    ServletContext context=getServletContext(); 
         String url=context.getInitParameter("url");
         String db=context.getInitParameter("dname");
         String user=context.getInitParameter("username");
         String p=context.getInitParameter("password");     
        
         PrintWriter out=response.getWriter();
         String d=request.getParameter("id");
         int id,check=0;
         try{
          check= Integer.parseInt(d);
         }
         catch(Exception e){
             
         }
         id=check;
         String pass=request.getParameter("userPass");
        try {  
            Class.forName(db);
            Connection conn = DriverManager.getConnection(url,user,p);
            
            
            
            Statement stmt=conn.createStatement();  
       
  
       
       ResultSet rs=stmt.executeQuery("Select password,ID from hostel.warden"); 
      
       while(rs.next()){
          String pwd= rs.getString(1);
          int coer_id =rs.getInt(2);
          
          if((pwd.equals(pass)) && (coer_id==id))
          {
              
           RequestDispatcher view = request.getRequestDispatcher("Warden_dashboard.html");
       view.forward(request, response);    
              
          }
           else
     {
        
          out.println("<!--\n" +
"Author: W3layouts\n" +
"Author URL: http://w3layouts.com\n" +
"License: Creative Commons Attribution 3.0 Unported\n" +
"License URL: http://creativecommons.org/licenses/by/3.0/\n" +
"-->\n" +
"<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<title>COER E-OUTPASS</title>\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
"<meta name=\"keywords\" content=\"Modern Subscribe Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design\" />\n" +
"<script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n" +
"<!-- Custom Theme files -->\n" +
"<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n" +
"<!-- //Custom Theme files -->\n" +
"<!-- web font -->\n" +
"<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'><!--web font-->\n" +
"<link href=\"//fonts.googleapis.com/css?family=Six+Caps\" rel=\"stylesheet\">\n" +
"<!-- //web font -->\n" +
"</head>\n" +
"<body>\n" +
"	<!-- main -->\n" +
"	<div class=\"w3agileits-main\">\n" +
"		\n" +
"		<div class=\"agileits-newsletter\">\n" +
"			<div class=\"w3ls-tabs\"> \n" +
"				<h1><font color='pink'>ATTENTION</h1>\n" +
"				<center>	<img src=\"coer.png\" style=\"width:100px;height:100px;\"></center>\n" +
"				<p>The details provided by you are incorrect."
                     + "            Please enter Valid details. </p>\n" +
                     "<h3><a href=\"index.html\"  class=\"wooo\"><p>Homepage</p></a></h2>"+


"			</body>\n" +
"</html>");
         
         
     }
          
          
           
       }
       
            
        } 
         catch (Exception ex) {
           out.println("<!--\n" +
"Author: W3layouts\n" +
"Author URL: http://w3layouts.com\n" +
"License: Creative Commons Attribution 3.0 Unported\n" +
"License URL: http://creativecommons.org/licenses/by/3.0/\n" +
"-->\n" +
"<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<title>COER E-OUTPASS</title>\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
"<meta name=\"keywords\" content=\"Modern Subscribe Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design\" />\n" +
"<script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n" +
"<!-- Custom Theme files -->\n" +
"<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n" +
"<!-- //Custom Theme files -->\n" +
"<!-- web font -->\n" +
"<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'><!--web font-->\n" +
"<link href=\"//fonts.googleapis.com/css?family=Six+Caps\" rel=\"stylesheet\">\n" +
"<!-- //web font -->\n" +
"</head>\n" +
"<body>\n" +
"	<!-- main -->\n" +
"	<div class=\"w3agileits-main\">\n" +
"		\n" +
"		<div class=\"agileits-newsletter\">\n" +
"			<div class=\"w3ls-tabs\"> \n" +
"				<h1><font color='white'>ATTENTION</h1>\n" +
"				<center>	<img src=\"coer.png\" style=\"width:100px;height:100px;\"></center>\n\n\n</br>" +
"			<font color='white'>	Something went wrong please try again "
                     + "            after some time. " +
  
                     "<h3><a href=\"index.html\"  class=\"wooo\"><p>Homepage</p></a></h2>"+

"			</body>\n" +
"</html>");
        }
  
  
  
  
  
  
    } 
        
    }
    
    
    
    
    
    
    
    

