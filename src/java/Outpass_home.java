/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JOSHI
 */
public class Outpass_home extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
           PrintWriter out = res.getWriter();  
          try{
              res.setContentType("text/html");  
     
          
          //String n=req.getParameter("uname");
        HttpSession session=req.getSession(false);
        String n=(String)session.getAttribute("uname");
      int p=Integer.parseInt((String)session.getAttribute("vid"));
        
        
            
   out.println("<!DOCTYPE html>\n" +
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
"	\n" +
"		\n" +

"		<div class=\"agileits-newsletter\">\n" +
"			<div class=\"w3ls-tabs\"> "+
"				<h1>DashBoard</h1></br>" +
"				<center><img class=\"img-circle\"	<img src=\"newjsp.jsp?id="+p+"\" style=\"width:120px;height:120px;\"></center>" +
"			" +"	<center><font color='white'></br>	<big>Welcome "+n+"</big></center>" +
"				<form action=check method=\"post\"> " +
"					<input type=\"submit\" value=\"Request New Outpass\">\n" +
"					<div class=\"clearfix\"> </div> \n" +
"				</form>\n" +
"				<form action=status method=\"post\"> \n" +
"					\n" +
"					<input type=\"submit\" value=\"Check outpass Status\">\n" +
"					<div class=\"clearfix\"> </div> \n" +
"				</form>\n" +
           "				<form action=emer.html method=\"post\"> \n" +
"					\n" +
"					<input type=\"submit\" value=\"Emergency Outpass\">\n" +
"					<div class=\"clearfix\"> </div> \n" +
"				</form>\n" +
"				<form action=out method=\"post\"> \n" +
"					\n" +
"					<input type=\"submit\" value=\"Logout\">\n" +
"					<div class=\"clearfix\"> </div> \n" +
"				</form>\n" +
"			</div>	\n" +
"		</div>	\n" +
"	</div>	\n" +
"	<!-- //main -->\n" +
"	<!-- copyright -->\n" +
"	<div class=\"copyright agileinfo\">\n" +
"		\n" +
"	</div>\n" +
"	<!-- //copyright --> \n" +
"</body>\n" +
"</html>");
   
 //HttpSession sess=req.getSession();
 //sess.setAttribute("id",p);


       //  out.close(); 
          }
           catch(Exception e)
           {                                   out.println("<!--\n" +
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
