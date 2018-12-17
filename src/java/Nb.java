

 import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.io.*;
import java.security.SecureRandom;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
 import java.util.Properties;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class Nb extends HttpServlet {
  
  

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
         String AB = "9876543210";
   String CD="0123456789";
   SecureRandom rnd = new SecureRandom();

   StringBuilder sb = new StringBuilder(4);
   for( int i = 0; i < 1; i++ ) 
      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
 for( int i = 0; i < 2; i++ ) 
      sb.append( CD.charAt( rnd.nextInt(CD.length()) ) );
 for( int i = 0; i < 1; i++ ) 
      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
 final String username = "coercollege@gmail.com";
		final String password = "teamspirit02345678";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session1 = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
    
   String ott=sb.toString();
   long user_id,check=0;
        String uid = request.getParameter("userId");
        try{
       check=Integer.parseInt(uid);
        }
        catch(Exception e){
         //   out.println("Illegal Entries");
        }
        user_id=check;
        String f_date = request.getParameter("fdate");
        
       SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
    
 
int flag=0;
    
        try { 
            ServletContext context=getServletContext();
String url=context.getInitParameter("url");
String db=context.getInitParameter("dname");
String user=context.getInitParameter("username");
String p=context.getInitParameter("password");
           Class.forName(db);  
  
   Connection conn = DriverManager.getConnection(url,user,p);
  

        Statement stmt=conn.createStatement();  
       
  
 
       ResultSet rs=stmt.executeQuery("Select COER_ID,EMAIL,DOB,Name,Password from hostel.hostel_table");  
        HttpSession session=request.getSession(true); 
        session.setAttribute("coer",uid);
   
              

      
         while(rs.next())  {
         
         long coer=rs.getInt(1);
         String Coer_id=String.valueOf(coer);
         String email=rs.getString(2);
        
         
         String d1=rs.getString(3);
         String n=rs.getString(4);
         String pass=rs.getString(5);
          
          
     if((user_id==coer)&&(f_date.equals(d1))){
     
         flag=1;
         if(pass==null){
         
         out.println("Error:Please Check your Internet Coonection");
      session.setAttribute("Coery",Coer_id);
     session.setAttribute("uname",n);
  
   PreparedStatement stm=conn.prepareStatement("UPDATE hostel.hostel_table SET Otp=? WHERE COER_ID=?"); 
   stm.setString(1,ott);
    stm.setLong(2,user_id);
    
     int k=stm.executeUpdate();
     if(k!=0){
         Message message = new MimeMessage(session1);
			message.setFrom(new InternetAddress("coercollege@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Coer E-Pass");
			message.setText( "E-Outpass@COER:Your One Time Password (OTP) is  :  "+ott);

			Transport.send(message);
               
      RequestDispatcher view = request.getRequestDispatcher("signupotp.html");
   
      
       view.forward(request, response);
         }
     else{
     out.println("Internal Error");
     }}
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
"			<font color='white'>	The CoerId/Date of Birth provided by you are already registered "
                     + "            if you have forgot your password please click the link below. " +
  
                     "<h3><a href=\"forgot.html\"  class=\"wooo\"><p>Forgot Password?</p></a></h2>"+

"			</body>\n" +
"</html>");
         }
     }}
     
 


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
"<title>COER E-OUTPASS</title>" +
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
"				\n" +
"				<p>The details provided by you are incorrect."
                     + "            Please enter Valid details. </p>\n" +
                                   "<h3><a href=\"index.html\"  class=\"wooo\"><p>Homepage</p></a></h2>"+

"			</body>\n" +
"</html>");
}
conn.close(); 
}
  
 
        catch(Exception e) {
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
