package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myjulife.*;

/**
 * Servlet implementation class Calculate
 */
@WebServlet("/Calculate")
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		int price=Integer.parseInt(request.getParameter("price"));
		response.setContentType("text/html;charset=utf-8");
		
		if(price<=15) {
			price+=1;
		}else if(price>15 && price<=30) {
			price+=2;
		}else if(price>30 && price<50) {
			price+=3;
		}
		
		Date time=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String finishTime=sdf.format(time);
		
		
		Commission cms=CmsManager.getCms(id);
		cms.setStatus(1);
		cms.setPrice(price);
		cms.setFinishTime(finishTime);
		
		HttpSession session=request.getSession();
		Runner runner=(Runner)session.getAttribute("runner");
		ArrayList<Commission> cmsList=runner.getCmsList();
		for(int i=0;i<runner.getCmsList().size();i++) {
			if(runner.getCmsList().get(i).getId().equals(id)) {
				runner.getCmsList().remove(i);
			}
		}
		ServletContext context=getServletContext();
		RequestDispatcher rd=context.getRequestDispatcher("/cms_content.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
