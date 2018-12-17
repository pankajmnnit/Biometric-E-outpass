/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import java.text.DateFormat;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.String;
import static java.lang.System.exit;
import java.security.SecureRandom;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Legen
 */
public class Final extends HttpServlet
{
 protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
 {
 ServletContext context=getServletContext();
String url=context.getInitParameter("url");
String db=context.getInitParameter("dname");
String user=context.getInitParameter("username");
String p=context.getInitParameter("password");

   String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
   String CD="0123456789";
   SecureRandom rnd = new SecureRandom();

   StringBuilder sb = new StringBuilder(7);
   for( int i = 0; i < 2; i++ ) 
      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
 for( int i = 0; i < 2; i++ ) 
      sb.append( CD.charAt( rnd.nextInt(CD.length()) ) );
 for( int i = 0; i < 3; i++ ) 
      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
 
    
   String outpass=sb.toString(); 
      HttpSession session=request.getSession(false); 
    
     PrintWriter out=response.getWriter();
    int c=(Integer)session.getAttribute("id");
   
   
    
     
     
    // int sid=Integer.parseInt(id);
//String sid=request.getParameter("id");
String reason=request.getParameter("car");
String place=request.getParameter("userPlace");
String time1=request.getParameter("userTimein");
String time2=request.getParameter("userTimeout");
try{
     Blob b = null;   
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
     Date date = new Date();
    Date tomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 24));
    Class.forName(db);
     Connection conn = DriverManager.getConnection(url,user,p);
   // PreparedStatement pr=conn.prepareStatement("INSERT INTO sed.joshi VALUES (?,'roorkee'',)");
    PreparedStatement pr=conn.prepareStatement("INSERT INTO hostel.outpass_data VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
    pr.setBlob(1,b);
    pr.setInt(2,c);
    
    pr.setString(3,(String)session.getAttribute("uname"));
  
    pr.setString(4,(String)session.getAttribute("fnam"));
    
    pr.setString(5,(String)session.getAttribute("mb"));
  
   
    pr.setString(6,(String)session.getAttribute("branch"));
    pr.setInt(7,(Integer)session.getAttribute("year"));
      pr.setString(8,outpass);
    pr.setInt(9,(Integer)session.getAttribute("room"));
   // pr.setTime(8,time.valueOf("12:00:00"));
   // pr.setTime(9,time.valueOf("20:00:00"));
    pr.setString(10,time1);
    pr.setString(11,time2);
    pr.setString(12,reason);
    pr.setString(13,"Granted");
  
   
    pr.setString(14,dateFormat.format(tomorrow));
   // pr.setDate(13,java.sql.Date.valueOf("2014/11/22"));
    pr.setString(15,place);
    pr.setInt(16,0);
    pr.setString(17,(String)session.getAttribute("em"));
   
    pr.setInt(18,0);
    pr.setString(19,"True");
    int k=pr.executeUpdate();
    conn.close();
    if(k!=0)
    {
        //out.println("successful");
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
"				<h1><font color='white'>SUCCESSFULL</h1>\n" +
"				<center>	<img src=\"coer.png\" style=\"width:100px;height:100px;\"></center>\n\n\n</br>" +
"			<font color='white'>	Your Emergency Outpass is granted successfully "
                     + "           you have to verify your emergency later on. " +
  
                     "<h3><a href=\"index.html\"  class=\"wooo\"><p>Homepage</p></a></h2>"+

"			</body>\n" +
"</html>");
    }
    else{
        
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
 catch(Exception e) {
   out.println(e);
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
