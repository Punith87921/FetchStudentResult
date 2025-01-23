

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FetchResult extends HttpServlet {
	Connection con=null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/studentresult";
	String username="root";
	String password="Punigowda@86";
	String sql = "select * from result where id=?";
	PrintWriter pw = null;
	
	public void init() {
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url,username,password);
			ps = con.prepareStatement(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
try {
	pw = res.getWriter();
			String id = req.getParameter("id");
			int cid = Integer.parseInt(id);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			
			
		if(rs.next()==true) {
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>Find Result</title>");
			pw.println("<style>");
			pw.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
			pw.println("center { margin-top: 50px; }");
			pw.println("h1 { color: green; }");
			pw.println("table { width: 80%; margin-top: 20px; border-collapse: collapse; }");
			pw.println("th, td { padding: 10px; text-align: left; border: 1px solid #ddd; }");
			pw.println("th { background-color: #4CAF50; color: white; }");
			pw.println("tr:nth-child(even) { background-color: #f2f2f2; }");
			pw.println("a { text-decoration: none; color: #007BFF; font-weight: bold; }");
			pw.println("a:hover { text-decoration: underline; }");
			pw.println("</style>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<center>");
			pw.println("<h1>Here is your Result:</h1>");
			pw.println("<table>");
			pw.println("<tr><th>Id</th><th>Name</th><th>Subject-1</th><th>Subject-2</th><th>Subject-3</th><th>Status</th></tr>");
			pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getInt(5)+"</td><td>"+rs.getString(6)+"</td></tr>");
			pw.println("</table>");
			pw.println("<br><br>");
			pw.println("<a href='http://localhost:9090/StudentResult/Resultpage.html'>Click here to ||<B>Fetch Result</B>|| again.</a>");
			pw.println("<p> About status (i.e, how the pass/fail is assigned): </p>");
			pw.println("<p>If (mark >= 35) :-> Status = <B>'Pass'</B></p>");
			pw.println("<p>If (mark < 35) :-> Status = <B>'Fail'</B></p>");
			pw.println("</center>");
			pw.println("</body>");
			pw.println("</html>");

		} else {
			pw.println("<!DOCTYPE html><html><head><title>Find Result</title></head><body><center>");
			pw.println("<h2>Invalid ID please try again...</h2>");
			pw.println("<a href='http://localhost:9090/StudentResult/Resultpage.html'>Click Here</a>");
			pw.println("</center></body></html>");
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
try {
			con.close();
			ps.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
