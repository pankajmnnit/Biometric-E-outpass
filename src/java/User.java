 import java.util.Date;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig(maxFileSize = 16177215)

public class User extends HttpServlet {

          private static final int BUFFER_SIZE = 4096;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false);
         String d=(String)session.getAttribute("Coery");
         String n=(String)session.getAttribute("uname");
       int user_id=Integer.parseInt(d);
        
        String pass1 = request.getParameter("pass");
        String pass2 = request.getParameter("newpass");
       
         InputStream inputStream = null; // input stream of the upload file
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            //obtains input stream of the upload file
            //the InputStream will point to a stream that contains
            //the contents of the file
            inputStream = filePart.getInputStream();
        }
int flag=0;
        if(pass1.equals(pass2)){
        try { 
             ServletContext context=getServletContext(); 
         String url=context.getInitParameter("url");
         String db=context.getInitParameter("dname");
         String user=context.getInitParameter("username");
         String p=context.getInitParameter("password");
           Class.forName(db);  
  

       Connection conn = DriverManager.getConnection(url,user,p);
  

       PreparedStatement stmt=conn.prepareStatement("UPDATE hostel.hostel_table SET PHOTO=?,Password=? WHERE COER_ID=?  ");  
     if (inputStream != null) {
                //files are treated as BLOB objects in database
                //here we're letting the JDBC driver
                //create a blob object based on the
                //input stream that contains the data of the file
                stmt.setBlob(1, inputStream);
            }
    stmt.setString(2,pass1);
    stmt.setInt(3,user_id);
    
     int k=stmt.executeUpdate();
     if(k!=0){
    
        //String n=(String)session.getAttribute("uname");
      
         
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
"                            <a href=\"credit.html\" ><center><img src=\"b.gif\" style=\"width:30px;height:30px;\"></center></a>\n" +
"				<h1>SUCCESS</h1>\n" +
"                             \n" +
"                                <center><img src=\"coer.png\" style=\"width:100px;height:100px;\"></center></br>\n" +
"				<font color='white'>Congratulations your account is successfully created/modified. Kindly login to your account.</br>\n" +
"				<form action=\"\" method=\"post\"> \n" +
					
"					<div class=\"clearfix\"> </div> \n" +
"					</form>	\n" +
"					<br>\n" +

"                                        \n" +
"					<p><a href=\"index.html\" class=\"wooo\">Home</a></p>\n" +
"					\n" +
"					</div>\n" +
"				\n" +
"			\n" +
"		</div>	\n" +
"	</div>	\n" +
"	\n" +
"	<!-- //main -->\n" +
"	<!-- copyright -->\n" +
"	\n" +
"	<!-- //copyright --> \n" +
"</body>\n" +
"</html>");
    }
  else
  out.println("Please enter correct entries");
      
        
   conn.close(); 
           }
  
 
        catch(Exception e) {
            System.out.println("Error");
        }
}
else
out.println("Please enter password correctly in both coloumns");
     
    }
}


