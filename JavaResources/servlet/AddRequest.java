package servlet;

import java.io.IOException;
import myjulife.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class AddRequest
 */
@WebServlet("/AddRequest")
public class AddRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRequest() {
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
		response.setContentType("text/json");
	    response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("UTF-8");
	    //获取用户信息与购物车内容
		String userId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		String text=request.getParameter("text");
		System.out.print(text);
		
		//create a cms
		Commission cms=new Commission();
		cms.setId(CmsManager.getCode());
		String title="";
		String type=request.getParameter("type");
		if(type.equals("1")) {
			title="超市购物";
		}
		else {}
		cms.setTitle(title);
		cms.setText(text);
		cms.setCreateTime(CmsManager.getCreateTime());
		cms.setUserInfo(userId, userName);
		CmsManager.addCms(cms);
	}

}
