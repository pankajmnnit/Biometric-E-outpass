/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JOSHI
 */

public class Prev_record extends HttpServlet {

    
  int counter=0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException 
              {
                   ServletContext context=getServletContext();
        String url=context.getInitParameter("url");
        String db=context.getInitParameter("dname");
        String user=context.getInitParameter("username");
        String p1=context.getInitParameter("password");
                  
                  response.setContentType("text/html");
        PrintWriter out=response.getWriter();
     try{
            Class.forName(db).newInstance();
            Connection conn = DriverManager.getConnection(url,user,p1);
            Statement stmt = conn.createStatement(); 
            
            
             ResultSet rs=stmt.executeQuery("select COER_ID,Name,Room_No,Branch,Year,Date,Place,OutpassReason from hostel.records");
             if (!rs.isBeforeFirst())
             {
                 counter=1;
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
"			<font color='white'>	There is no record to display. "
                     + "   Please check after sometime.       " +
  
                     "<h3><a href=\"Warden_dashboard.html\"  class=\"wooo\"><p>Dashboard</p></a></h2>"+

"			</body>\n" +
"</html>");
                 
             }
            if(counter==0)
                {
              String str="<!DOCTYPE html>\n" +
"<html >\n" +
"<head>\n" +
"  <meta charset=\"UTF-8\">\n" +
"<title>COER E-OUTPASS</title>" +
"  <script src=\"http://s.codepen.io/assets/libs/modernizr.js\" type=\"text/javascript\"></script>\n" +
"\n" +
"\n" +
"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css\">\n" +
"\n" +
"  \n" +
"      <link rel=\"stylesheet\" href=\"css/style1.css\">\n" +
"\n" +
"  \n" +
"</head>\n" +
"\n" +
"<body>\n" +
" <center> <h1>STUDENTS LIST</h1> </center>\n" +
"<table border=1 class=\"rwd-table\">\n" +
"  <tr>\n" +
"    <th>COER_ID</th><th>NAME</th>\n" +
"    <th>ROOM_NO</th>\n" +
"    <th>BRANCH</th>\n" +
"	 <th>YEAR</th>\n" +
"    <th>DATE</th>\n" +
"    <th>PLACE</th>\n" +
"	 <th>REASON</th>\n" +
"  </tr>\n";

             while(rs.next())
              {
                  
                  String p=rs.getString(1);
                  str +="<tr><td data-th=\"COER_ID\">"+rs.getString(1)+"</td><td data-th=\"NAME\">"+rs.getString(2)+"</td><td data-th=\"ROOM_NO\">"+rs.getString(3)+"</td><td data-th=\"BRANCH\">"+rs.getString(4)+"</td><td data-th=\"YEAR\">"+rs.getString(5)+"</td><td data-th=\"DATE\">"+rs.getString(6)+"</td><td data-th=\"PLACE\">"+rs.getString(7)+"</td><td data-th=\"REASON\">"+rs.getString(8)+"</td></tr>";
                  
               
              }
              str +="</table>" +
"  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n" +
"\n" +
"    <script src=\"js/index.js\"></script>\n" +
"\n" +
"</body>\n" +
"</html>";  
              out.println(str);
              conn.close();
             
     }
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
