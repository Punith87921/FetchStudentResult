

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

public class Login extends HttpServlet {
	Connection con = null;
	PreparedStatement ps = null;
	//PreparedStatement ps1 = null;
	ResultSet rs = null;
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/studentresult?user=root&password=Punigowda@86";
	String sql = "Select * from user where id=?";
	

	public void init() {
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url);
			ps = con.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			
			PrintWriter pw = res.getWriter();
			String id = req.getParameter("uid");
			int cid = Integer.parseInt(id);
			String password = req.getParameter("pwd");
			
			ps.setInt(1, cid);
			//ps.setString(3, password);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
			res.sendRedirect("http://localhost:9090/StudentResult/Resultpage.html");
			} else {
				pw.println("<html><body><h1>login Failed...</h1>");
						pw.println("<a href='http://localhost:9090/StudentResult/Login.html'>Please try again...</a></body></html>");
			}
			

} catch (Exception e) {
	e.printStackTrace();
}
	}
	public void destroy() {
		try {
			con.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
