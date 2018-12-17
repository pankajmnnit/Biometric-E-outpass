/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Properties;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.*;
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
/**
 *
 * @author JOSHI
 */
public class Action_Warden extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       ServletContext context=getServletContext();
       String url=context.getInitParameter("url");
       String db=context.getInitParameter("dname");
       String user=context.getInitParameter("username");
       String p=context.getInitParameter("password"); 
        
        //HttpSession session=request.getSession(false);
         final String username = "coercollege@gmail.com";
		final String password = "teamspirit02345678";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
      
       
        PrintWriter out=response.getWriter();
   
        
       try{
             
        String[] checkedIds = request.getParameterValues("action");
         
         int j=checkedIds.length;
         
         Class.forName(db);  
          int counter=0;  

        Connection conn = DriverManager.getConnection(url,user,p);
        	
  
       Statement stmt=conn.createStatement();  
       ResultSet rs=stmt.executeQuery("Select COER_ID from hostel.outpass_data"); 
       
       
       while(rs.next())
       {
           
           counter++;
           
       }
       
       
       String Num=null;
       String pass=null;
       //out.println(counter);
       //out.println("id is "+checkedIds[1]);
       
       for(int i=0;i<counter;i++)
       { if(i==counter){
       break;
       }
          String str= checkedIds[i];
          PreparedStatement pr=conn.prepareStatement("UPDATE outpass_data SET Confirmation=(?),Changed=(?) WHERE COER_ID=(?)");
          pr.setString(1,"Granted");
          pr.setInt(2,1);
          pr.setString(3,str);
         pr.executeUpdate();
         int d=Integer.parseInt(str);
         
         ResultSet r=stmt.executeQuery("Select EMAIL,Outpass_No from outpass_data WHERE COER_ID="+d); 
         while (r.next())
         {
               Num=r.getString(1);
               pass=r.getString(2);
         }
       // out.println(Num);
     Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("coercollege@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(Num));
			message.setSubject("Coer E-Pass");
                        
                        
			message.setText( "E-Outpass@COER:Congrats your Outpass Has Been Confirmed.Please take your Coer Id card for outing with you.");

			Transport.send(message);

	

       }
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
"				<h1><font color='white'>SUCCESS</h1>\n" +
"				<center>	<img src=\"coer.png\" style=\"width:100px;height:100px;\"></center>\n\n\n</br>" +
"			<font color='white'>	The outpass verified by you are successfully "
                     + "           submitted & a message has been sent to the student. " +
  
                     "<h3><a href=\"Warden_dashboard.html\"  class=\"wooo\"><p>Dashboard</p></a></h2>"+

"			</body>\n" +
"</html>");
       }
       catch(ArrayIndexOutOfBoundsException e1){
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
"				<h1><font color='pink'>SUCCESS</h1>\n" +
"				<center>	<img src=\"coer.png\" style=\"width:100px;height:100px;\"></center>\n\n\n</br>" +
"			<font color='white'>	The outpass verified by you are successfully "
                     + "           submitted & a email has been sent to the student. " +
  
                     "<h3><a href=\"Warden_dashboard.html\"  class=\"wooo\"><p>Dashboard</p></a></h2>"+

"			</body>\n" +
"</html>");
       }
        catch(Exception e)
        {
          
          // RequestDispatcher rd = request.getRequestDispatcher("Warden_dashboard.html");
         //  rd.forward(request, response);
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
  
                     "<h3><a href=\"Warden_dashboard.html\"  class=\"wooo\"><p>Dashboard</p></a></h2>"+

"			</body>\n" +
"</html>");
              
        }
 
}
}