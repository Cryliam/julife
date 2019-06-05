package servlet;

import myjulife.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetTaxiCms
 */
@WebServlet("/GetTaxiCms")
public class GetTaxiCms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTaxiCms() {
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
	    
	    

	   
	    
	    
	    
	    
	    
	    String openid=request.getParameter("openid");
	    boolean flag=false;
	    
	    JSONArray list=new JSONArray();
	    //先在list0中检测用户是否已经发起请求，若是则返回结果
	    for(int i=0;i<TaxiCmsManager.getList0().size();i++) {
	    	if(TaxiCmsManager.getList0().get(i).getRequesterId().equals(openid)) {
	    		TaxiCms tc=TaxiCmsManager.getList0().get(i);
	    		JSONObject json=new JSONObject();
	    		json.put("flag", true);
	    		json.put("id", tc.getId());
    			json.put("aim", tc.getAim());
    			json.put("temp", tc.getTemp());
    			json.put("createDay", tc.getCreateDay());
    			json.put("status", tc.getStatus());
	    		out.print(json);
	    		flag=true;
	    		break;
	    	}
	    }
	    //再在list1检测，若有，直接返回对方的坐标
	    if(flag==false) {
	    	for(int i=0;i<TaxiCmsManager.getList1().size();i++) {
	    		if(TaxiCmsManager.getList1().get(i).getRequesterId().equals(openid)
	    			||TaxiCmsManager.getList1().get(i).getAccepterId().equals(openid)) {
	    			
	    			JSONObject json=new JSONObject();
		    		if(TaxiCmsManager.getList0().get(i).getRequesterId().equals(openid)) {
		    			TaxiCms tc=TaxiCmsManager.getList1().get(i);
		    		
		    			json.put("flag", true);
		    			json.put("aim", tc.getAim());
		    			json.put("temp", tc.getTemp());
		    			json.put("name", tc.getAccepterName());
		    			json.put("avatar", tc.getAccepterAvatar());
		    			json.put("latitude",tc.getAccepterLatitude());
		    			json.put("longitude", tc.getAccepterLongitude());
		    			json.put("createDay", tc.getCreateDay());
			    		json.put("gender", tc.getAccepterGender());
		    			json.put("status", tc.getStatus());
		    		}
		    		else if(TaxiCmsManager.getList1().get(i).getAccepterId().equals(openid)) {
		    			TaxiCms tc=TaxiCmsManager.getList1().get(i);
		    			
		    			json.put("flag", true);
		    			json.put("aim", tc.getAim());
		    			json.put("temp", tc.getTemp());
		    			json.put("name", tc.getRequesterName());
		    			json.put("avatar", tc.getRequesterAvatar());
		    			json.put("gender", tc.getRequesterGender());
		    			json.put("latitude",tc.getRequesterLatitude());
		    			json.put("longitude", tc.getRequesterLongitude());
		    			json.put("createDay", tc.getCreateDay());
		    			json.put("status", tc.getStatus());
		    		}
	    			out.print(json);
	    			flag=true;
	    			break;
	    		}
	    	}
	    }
	    
	    
	    if(flag==false) {
	    	for(int i=0;i<TaxiCmsManager.getList0().size();i++) {
	    		TaxiCms tc=TaxiCmsManager.getList0().get(i);
	    		JSONObject json=new JSONObject();
	    		json.put("flag", false);
	    		json.put("id", tc.getId());
	    		json.put("aim", tc.getAim());
	    		json.put("temp", tc.getTemp());
	    		json.put("createDay", tc.getCreateDay());
	    		json.put("requesterName", tc.getRequesterName());
	    		json.put("requesterAvatar", tc.getRequesterAvatar());
	    		json.put("requesterGender", tc.getRequesterGender());
	    		json.put("number", tc.getNumber());
	    		list.add(json);
	    	}
	    	out.print(list);
	    }
	    out.close();
	    
	}

}
