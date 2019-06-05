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
 * Servlet implementation class RenewLocation
 */
@WebServlet("/RenewLocation")
public class RenewLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RenewLocation() {
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
		
		String type=request.getParameter("type");
		String id=request.getParameter("id");
		double latitude=Double.parseDouble(request.getParameter("latitude"));
		double longitude=Double.parseDouble(request.getParameter("longitude"));
		double lati=0;
		double longi=0;
		
		TaxiCms tc=TaxiCmsManager.getReceivedTaxiCms(id);
		
		if(type.equals("requester")) {
			tc.setRequesterLatitude(latitude);
			tc.setRequesterLongitude(longitude);
			lati=tc.getAccepterLatitude();
			longi=tc.getAccepterLongitude();
		}
		else if(type.equals("accepter")) {
			tc.setAccepterLatitude(latitude);
			tc.setAccepterLongitude(longitude);
			//tc.setRequesterLatitude(tc.getRequesterLatitude()+0.0002);//test
			//tc.setRequesterLongitude(tc.getRequesterLongitude()+0.0002);//test
			lati=tc.getRequesterLatitude();
			longi=tc.getRequesterLongitude();
		}
		
		
		JSONObject json=new JSONObject();
		json.put("latitude", lati);
		json.put("longitude", longi);

		PrintWriter out=response.getWriter();
		out.print(json);
	}

}
