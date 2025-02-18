

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Signup extends HttpServlet {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/studentresult?user=root&password=Punigowda@86";
	String sql = "insert into user values(?,?,?,?)";
	
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
			String id = req.getParameter("uid");
			int cid = Integer.parseInt(id);
			String email = req.getParameter("email");
			String name = req.getParameter("un");
			String pwd = req.getParameter("pwd");
			
			ps.setInt(1, cid);
			ps.setString(2, email);
			ps.setString(3, name);
			ps.setString(4, pwd);
			
			
			int nora = ps.executeUpdate();
			if(nora == 1) {
				res.sendRedirect("http://localhost:9090/StudentResult/Login.html");
			} else {
				res.sendRedirect("http://localhost:9090/StudentResult/Signup.html");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void destroy () {
		try {
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
