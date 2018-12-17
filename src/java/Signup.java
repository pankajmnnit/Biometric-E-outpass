/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JOSHI
 */
@WebServlet(urlPatterns = {"/reg"})
public class Signup extends HttpServlet {

   
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException 
    {
         
       
        int flag=0;
        int check=0,id;
        PrintWriter out=res.getWriter();
          String d=(String)req.getParameter("userId");
          try{
         check=Integer.parseInt(d);}
          catch(Exception e){
            // out.println("Illegal Entries");
          }
          id=check;
        String password=req.getParameter("userPass");
         ServletContext context=getServletContext(); 
         String url=context.getInitParameter("url");
         String db=context.getInitParameter("dname");
         String user=context.getInitParameter("username");
         String p=context.getInitParameter("password");
      
        
        try{
           
            Class.forName(db);
            
            
             Connection con = DriverManager.getConnection(url,user,p);
            Statement stmt = con.createStatement(); 
            HttpSession session=req.getSession();
           res.setContentType("text/HTML");
            
         ResultSet rs=stmt.executeQuery("select * from hostel.hostel_table");
         
         while(rs.next())  {
         int coer_id=rs.getInt("COER_ID");
         String pass=rs.getString("Password");
         String name=rs.getString("Name");
        String fname=rs.getString("F_Name");
         String branch=rs.getString("Branch");
         int room=rs.getInt("Room_No");
         int yr=rs.getInt("Year");
         String mb=rs.getString("Mob_No");
         String email=rs.getString("EMAIL");
         
         //creating form that have invisible textfield  
         //out.print("<a href='Student?uname="+name+"'>visit</a>");
         //res.sendRedirect("s2?user_name="+name+"");
         
          //out.print("<a href='s2?uname="+name+"'>visit</a>");  
           
         
          if((id==coer_id)&&(password.equals(pass))){
              flag=1;
              session.setAttribute("uname",name);
              String Coer=String.valueOf(coer_id);
              session.setAttribute("id",coer_id);
              session.setAttribute("vid",Coer);
              session.setAttribute("fnam",fname);
              session.setAttribute("branch",branch);
              session.setAttribute("room",room);
              session.setAttribute("year",yr);
              session.setAttribute("mb",mb);
              session.setAttribute("em",email);
             RequestDispatcher rd = req.getRequestDispatcher("/s2");
             rd.forward(req, res);
             
          }
    
           
          /*
             */ 
            }
         if(flag==0){
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
"			<font color='white'>	The CoerId/Password provided by you are incorrect "
                     + "            if you have forgot your password please click the link below. " +
  
                     "<h3><a href=\"forgot.html\"  class=\"wooo\"><p>Forgot Password?</p></a></h2>"+

"			</body>\n" +
"</html>");
         }
            
      out.close();
        }
        catch(Exception e)
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
