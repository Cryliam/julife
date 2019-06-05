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
 * Servlet implementation class GetReceivedTaxiCms
 */
@WebServlet("/GetReceivedTaxiCms")
public class GetReceivedTaxiCms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReceivedTaxiCms() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/json");
	    response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("UTF-8");
	    PrintWriter out=response.getWriter();
	    
	    String openid=request.getParameter("openid");
	    JSONObject json=null;
	    for(int i=0;i<TaxiCmsManager.getList0().size();i++) {
    		if(TaxiCmsManager.getList0().get(i).getRequesterId().equals(openid)) {
    			//若用户为Requester
	    		
	    			TaxiCms tc=TaxiCmsManager.getList0().get(i);
	    			json=new JSONObject();
	    			json.put("aim", tc.getAim());
	    			json.put("temp", tc.getTemp());
	    			json.put("name", tc.getAccepterName());
	    			json.put("avatar", tc.getAccepterAvatar());
	    			json.put("gender", tc.getAccepterGender());
	    			json.put("latitude",tc.getAccepterLatitude());
	    			json.put("longitude", tc.getAccepterLongitude());
	    			json.put("createDay", tc.getCreateDay());
	    			json.put("status", tc.getStatus());
	    			break;
    		}
    		
    	}
	    
	    
    	for(int i=0;i<TaxiCmsManager.getList1().size();i++) {
    		if(TaxiCmsManager.getList1().get(i).getRequesterId().equals(openid)
    			||TaxiCmsManager.getList1().get(i).getAccepterId().equals(openid)) {
    			
    			//若用户为Requester
	    		if(TaxiCmsManager.getList1().get(i).getRequesterId().equals(openid)) {
	    			TaxiCms tc=TaxiCmsManager.getList1().get(i);
	    			json=new JSONObject();
	    			json.put("aim", tc.getAim());
	    			json.put("temp", tc.getTemp());
	    			json.put("name", tc.getAccepterName());
	    			json.put("avatar", tc.getAccepterAvatar());
	    			json.put("gender", tc.getAccepterGender());
	    			json.put("latitude",tc.getAccepterLatitude());
	    			json.put("longitude", tc.getAccepterLongitude());
	    			json.put("createDay", tc.getCreateDay());
	    			json.put("status", tc.getStatus());
	    			break;
	    		}
	    		//若用户为Accepter
	    		else if(TaxiCmsManager.getList1().get(i).getAccepterId().equals(openid)) {
	    			TaxiCms tc=TaxiCmsManager.getList1().get(i);
	    			json=new JSONObject();
	    			json.put("aim", tc.getAim());
	    			json.put("temp", tc.getTemp());
	    			json.put("name", tc.getRequesterName());
	    			json.put("avatar", tc.getRequesterAvatar());
	    			json.put("gender", tc.getRequesterGender());
	    			json.put("latitude",tc.getRequesterLatitude());
	    			json.put("longitude", tc.getRequesterLongitude());
	    			json.put("createDay", tc.getCreateDay());
	    			json.put("status", tc.getStatus());
	    			break;
	    		}
    		}
    		
    	}
    	out.print(json);
		out.close();

		
	}

}
