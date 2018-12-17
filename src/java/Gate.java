
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JOSHI
 */
public class Gate  extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        int k=1;
        PrintWriter out=response.getWriter();
        HttpSession session = request.getSession();
        ServletContext context=getServletContext();
       String url=context.getInitParameter("url");
       String db=context.getInitParameter("dname");
       String user=context.getInitParameter("username");
       String p=context.getInitParameter("password");

        
        String passno=request.getParameter("pass_no");
        try {  
            
            Class.forName(db);
             Connection conn = DriverManager.getConnection(url,user,p);
        Statement stmt=conn.createStatement();  
        
        ResultSet rs=stmt.executeQuery("Select * from hostel.outpass_data where COER_ID='"+passno+"'and Confirmation='Granted'"); 
    
       if (!rs.isBeforeFirst())
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
"			<font color='white'>No records found contact your supervisor. "
                     + "            after some time. " +
  
                     "<h3><a href=\"gate.html\"  class=\"wooo\"><p>Gate Home</p></a></h2>"+

"			</body>\n" +
"</html>");
                }
       else
       {
        while (rs.next()){
        int id=rs.getInt("COER_ID");
        String name=rs.getString("NAME");
        String mb=rs.getString("Mob_No");
        String branch=rs.getString("Branch");
        String year=rs.getString("Year");
        String outpass=rs.getString("Outpass_No");
        int room=rs.getInt("Room_No");
        String in=rs.getString("TIME_IN");
        String ot=rs.getString("TIME_OUT");
        String date=rs.getString("DATE");
        int change=rs.getInt("Changed");
         session.setAttribute("myId",id);
         if(change==0)
         {
             k=0;
             break;
         }
         out.println("<html>\n" +
"<center><body>" +"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"+
"" +
"<table border=\"1\" cellpadding=\"3\" cellspacing=\"3\"  bordercolor=\"#000000\"  width=\"200\" height=\"150\" >\n" +
"\n" +
"<caption><img src=\"pj.jpg\" width=\"500\" height=\"100\"></caption\n" +
"<caption>");
         out.println("<tr><center></th><td colspan ='4'><center><img src=\"newjsp.jsp?id="+id+"\" alt=\"\" border='1' height='124' width='124' /></center></td></th>\n" +
"</center</tr>\n"+"<tr>\n" +
"<th>Outpass No:</th>\n" +
"<th>"+outpass+
"<tr>\n" +
"<th>Name:</th>\n" +
"<th>"+name+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>COER ID:</th>\n" +
"<th>"+id+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Year:</th>\n" +
"<th>"+year+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Hostel:</th>\n" +
"<th>AHB</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Room No</th>\n" +
"<th>"+room+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Time Out</th>\n" +
"<th>"+ot+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Time In</th>\n" +
"<th>"+in+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Branch:</th>\n" +
"<th>"+branch+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Mobile No:</th>\n" +
"<th>"+mb+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Date:</th>\n" +
"<th>"+date+"</th>\n" +
"</tr>\n" +
"<tr> \n" +
"<th colspan=\"2\">\n" +
"In case of any emergency inform on Tel:01332-279737,276797</th>\n" +
"</tr>\n" +
"\n" +
" <script type=\"text/javascript\">\n" +
"function callservlet() {\n" +
"\n" +
"  document.forms.xyz.submit();\n" +
"}\n" +
"</script>"+
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"<form name=\"xyz\" action=\"./update\" method=\"post\">"+
"</table>\n<input type=\"button\" value=\"Print this page\" onClick=\"window.print();callservlet()\">" +
"</center></body>\n" +
"\n" +
"</html>");
     } 
        }
       if(k==0)
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
"			<font color='white'>	You have already printed the outpass. "
                     + "          " +
  
                     "<h3><a href=\"gate.html\"  class=\"wooo\"><p>Gate Home</p></a></h2>"+

"			</body>\n" +
"</html>");
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
  
                     "<h3><a href=\"gate.html\"  class=\"wooo\"><p>Gate Home</p></a></h2>"+

"			</body>\n" +
"</html>");
        }
    }
    
    
    
}
