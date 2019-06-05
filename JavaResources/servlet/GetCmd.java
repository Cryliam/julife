package servlet;
import myjulife.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetCmd
 */
@WebServlet("/GetCmd")
public class GetCmd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCmd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
	    response.setCharacterEncoding("utf-8");
		String tagS=request.getParameter("tag");
		PrintWriter out=response.getWriter();
		if(tagS!=null) {
		int tag=Integer.parseInt(tagS);
		ArrayList<Commodity> cmdList=CmdManager.getCmdList(tag);
		JSONArray arr=new JSONArray();
		arr.clear();
		for(int i=0;i<cmdList.size();i++) {
			String cmdId=cmdList.get(i).getId();
			String cmdName=cmdList.get(i).getName();
			JSONObject json=new JSONObject();
			json.put("cmdid", cmdId);
			json.put("cmdname", cmdName);
			arr.add(json);
		}
		
		out.print(arr);
		}
		else if(tagS==null) {
			out.print(1);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
