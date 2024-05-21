import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.net.*;
public class servletlogin extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		Connection cn;
		Statement st=null;
		ResultSet rs;
		String uname = req.getParameter("uid");
	 	String pwd = req.getParameter("pwd");
		try{
	
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   	   cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	   	   st=cn.createStatement();
		   
			
			if(uname.trim().length()>0){
				if(pwd .trim().length()>0){
					rs=st.executeQuery("Select password from LOGIN where username='"+uname+"'");
					if(rs.next()){
						 if(rs.getString(1).equals(pwd)){
						 res.sendRedirect("http://localhost:8081/TYDIP/sub.html");
						 
						 }
						 else{
						
						 out.println("<font size=8 color=blue>");
                        			 out.println("<blink>Invalid Password</blink>");
						 }
					}
					else{
					
					out.println("<font size=8 color=blue>");
                        		out.println("<blink>Invalid Username</blink>");
					}
					
				}
				 else{
				 
				 out.println("<font size=8 color=blue>");
                       		 out.println("<blink>Password field cannot be blank!!</blink>");
		 		 }
			}
			else{
			
			out.println("<font size=8 color=blue>");
                        out.println("<blink>Username field cannot be blank!!</blink>");
		 	}	
	

		}
		catch(Exception e){
	 	 out.println(e);
			}		


		out.close();
	}

}




/*}
		//out.println("<font size=8 color="blue">");
               //out.println("Authorised USER");
		<a href='http://peers:8080/adlogin.html'>Back</a>
	      	 catch(Exception e){
	 	 out.println(e);
		}

		 try{*/