package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import myjulife.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AddCmd")
public class AddCmd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCmd() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json");
	    response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("UTF-8");
	    HttpSession session=request.getSession();
	    JSONArray cart=(JSONArray)session.getAttribute("cart");
		
		if(cart==null) {
			cart=new JSONArray();
		}
		String cmdId=request.getParameter("cmdId");
		int num=1;
		int tag=Integer.parseInt(request.getParameter("tag"));
		Commodity cmd=CmdManager.getCmd(cmdId, tag);
		String cmdName=cmd.getName();
		JSONObject json=new JSONObject();
		json.put("cmdName", cmdName);
		json.put("num", num);
		
		boolean in=false;
		if(cart.size()>0) {
			System.out.print(111);
			for(int i=0;i<cart.size();i++) {
				JSONObject temp=(JSONObject)cart.getJSONObject(i);
				if(temp.get("cmdName").equals(cmdName)) {
					int newNum=temp.getInt("num")+1;
					temp.put("num",newNum);
					cart.add(temp);
					in=true;
				}
			}
		}
		if(cart.size()==0 || in==false) {
			cart.add(json);
		}
		session.setAttribute("cart", cart);
		PrintWriter out=response.getWriter();
		out.print(cart);
	}

}
