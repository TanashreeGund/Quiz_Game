import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.net.*;
import java.util.*;

public class servletjavaq extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		Connection cn;
		Statement st=null;
		ResultSet rs;
		ArrayList<String> ans=new ArrayList<String>();
		ArrayList<String> uans=new ArrayList<String>();
		int cnt=0;
		String op1=req.getParameter("QO1");	
	
		try{
	
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   	   cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	   	   st=cn.createStatement();
		   rs=st.executeQuery("select * from javaans");
		   while(rs.next())
	 	   {
		   	ans.add(rs.getString(1));
		   }


		  for(int i=1;i<=10;i++){
		  uans.add(req.getParameter("QO"+i));
		   }
		  

		  out.println(ans);
		  out.println(uans);
		  
		  for(int i=1;i<=10;i++){
		  if(uans.get(i).equals(ans.get(i)))
		  {
			cnt=cnt+1;
		  }
		  }
		  out.println("Congratulations you have got "+cnt);
		  		
		 }

		catch(Exception e){
	 	 out.println(e);
		}
		
		
		out.close();
}
}