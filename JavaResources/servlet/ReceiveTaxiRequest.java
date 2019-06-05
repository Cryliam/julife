package servlet;

import myjulife.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReceiveTaxiRequest
 */
@WebServlet("/ReceiveTaxiRequest")
public class ReceiveTaxiRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveTaxiRequest() {
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
	    
	    //Get parameters from requester
	    String openid=request.getParameter("openid");
	    String name=request.getParameter("name");
	    String avatar=request.getParameter("avatar");
	    String gender=request.getParameter("gender");//1-male 2-female
	    String id=request.getParameter("id");
	    
	    
	    //find the taxicms and change the parameters
	    TaxiCms tc=TaxiCmsManager.getTaxiCms(id);
	    tc.setAccepterId(openid);
	    tc.setAccepterName(name);
	    tc.setAccepterAvatar(avatar);
	    tc.setAccepterGender(gender);
	    tc.setStatus("1");
	    TaxiCmsManager.receive(id);
	}

}
