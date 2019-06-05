package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myjulife.*;

/**
 * Servlet implementation class LoginHandler
 */
@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session=request.getSession();
		
		
		
		
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String type=request.getParameter("usrType");
		ResultSet res=null;
		String username=null;
	    String checked="";
	    String tel="未设置";
	    String addr="未设置";
		User user;
		Runner runner;
	    
		//通过数据库验证账号信息
		
		
		try {
			//建立数据库连接
			String dbDriver="com.mysql.jdbc.Driver";
			Class.forName(dbDriver);
			String url="jdbc:mysql://localhost:3306/JURunner";
			Connection con=DriverManager.getConnection(url,"root","63005730");
			
			//若用户类型为user，查询表accounts，将用户名查询结果放在username中
			if(type.equals("user")) {
				String sql="select name from accounts where id=? and pswd=?;";
				PreparedStatement state=con.prepareStatement(sql);
				state.setString(1, account);
				state.setString(2, password);
				res=state.executeQuery();
				while(res.next()) {
					username=res.getString(1);
				}
				//获取当前会话的User对象，若空，则创建一个新对象
				
				if(username!=null) {
					sql="select tel,addr from userinfo where id=?";
					state=con.prepareStatement(sql);
					state.setString(1, account);;
					res=state.executeQuery();
					while(res.next()) {
						tel=res.getString(1);
						addr=res.getString(2);
					}
					
					
					user=(User)session.getAttribute("user");
					if(user==null) {
						user=new User(account);
						user.setName(username);
						user.setTel(tel);
						user.setAddr(addr);
						session.setAttribute("user", user);
					}
					session.setAttribute("username", username);
					session.setAttribute("type", "user");
					checked="true";
					session.setAttribute("checked", checked);
					con.close();
					response.sendRedirect("index.jsp");
				}
				else {
					con.close();
					checked="false";
					session.setAttribute("checked", checked);
					response.sendRedirect("login.jsp");
					}
			}
			
			
			
			
			
			
			//若用户类型为runner，查询表runners
			else {
				String sql="select name from runners where id=? and password=?;";
				PreparedStatement state=con.prepareStatement(sql);
			
				state.setString(1, account);
				state.setString(2, password);
				res=state.executeQuery();
				while(res.next()) {
					username=res.getString(1);
				}
				
				
				if(username!=null) {
					sql="select tel from userinfo where id=?";
					state=con.prepareStatement(sql);
					state.setString(1, account);;
					res=state.executeQuery();
					while(res.next()) {
						tel=res.getString(1);
					}
					runner=(Runner)session.getAttribute("runner");
					if(runner==null) {
						runner=new Runner(account);
						runner.setName(username);
						runner.setTel(tel);
						session.setAttribute("runner", runner);
					}
					session.setAttribute("username", username);
					session.setAttribute("type", "runner");
					checked="true";
					session.setAttribute("checked", checked);
					con.close();
					response.sendRedirect("indexR.jsp");
				}
				else {
					con.close();
					checked="false";
					session.setAttribute("checked", checked);
					response.sendRedirect("login.jsp");
					}
			}
			
				//若username不为空，说明存在结果，验证通过。
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	}

}
