package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import myjulife.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetMyRun
 */
@WebServlet("/GetMyRun")
public class GetMyRun extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyRun() {
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
		String userId=request.getParameter("userId");
		JSONArray myList=new JSONArray();
		for(int i=0;i<CmsManager.getList().size();i++) {
			if(CmsManager.getList().get(i).getuserId().equals(userId)) {
				Commission cms=CmsManager.getList().get(i);
				JSONObject json=new JSONObject();
				json.put("cmsId", cms.getId());
				json.put("title",cms.getTitle());
				json.put("text",cms.getText());
				json.put("runnerName",cms.getRunnerName());
				json.put("runnerTel",cms.getRunnerTel());
				json.put("createTime", cms.getCreateTime());
				json.put("status", cms.getStatus());
				json.put("finishTime",cms.getFinishTime());
				myList.add(json);
			}
		}
		
		PrintWriter out=response.getWriter();
		out.print(myList);
	}

}
