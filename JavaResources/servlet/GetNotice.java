package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myjulife.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetNotice
 */
@WebServlet("/GetNotice")
public class GetNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNotice() {
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
	    PrintWriter out=response.getWriter();
	    
	    JSONArray list=new JSONArray();
	    for(int i=0;i<NoticeManager.list.size();i++) {
	    	Notice notice=NoticeManager.list.get(i);
	    	JSONObject json=new JSONObject();
	    	json.put("title", notice.getTitle());
	    	json.put("addr", notice.getAddr());
	    	json.put("createrName", notice.getCreaterName());
	    	json.put("createrAvatar", notice.getCreaterAvatar());
	    	json.put("type", notice.getType());
	    	list.add(json);
	    }
	    
	    out.print(list);
	    out.close();
	}

}
