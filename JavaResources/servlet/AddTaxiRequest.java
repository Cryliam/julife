package servlet;

import myjulife.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTaxiRequest
 */
@WebServlet("/AddTaxiRequest")
public class AddTaxiRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaxiRequest() {
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
	    String requesterName=request.getParameter("name");
	    String requesterAvatar=request.getParameter("avatar");
	    String requesterGender=request.getParameter("gender");//1-male 2-female
	    String requesterTel=request.getParameter("tel");
	    String aim=request.getParameter("aim");
	    String temp=request.getParameter("temp");
	    int number=Integer.parseInt(request.getParameter("number"));
	    
	    //create a TaxiCms object and set parameters
	    TaxiCms tc=new TaxiCms(TaxiCmsManager.getCode());
	    tc.setRequesterId(openid);
	    tc.setRequesterName(requesterName);
	    tc.setRequesterAvatar(requesterAvatar);
	    tc.setRequesterGender(requesterGender);
	    tc.setRequesterTel(requesterTel);
	    tc.setAim(aim);
	    tc.setTemp(temp);
	    tc.setStatus("-1");
	    tc.setCreateTime(TaxiCmsManager.getCreateTime());
	    tc.setCreateDay(TaxiCmsManager.getCreateDay());
	    tc.setNumber(4-number);
	    
	    //add the new object
	    TaxiCmsManager.add(tc);
	    
	    //System.out.print(tc.getAim()+"\n"+tc.getTemp()+"\n"+tc.getRequesterName()+"\n"+tc.getRequesterGender()+"\n"
	    	//+tc.getNumber()+"\n"+tc.getRequesterTel()
	    		//);
	   
	}

}
