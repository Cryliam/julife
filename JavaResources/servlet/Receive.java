package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myjulife.*;

/**
 * Servlet implementation class Receive
 */
@WebServlet("/Receive")
public class Receive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Receive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Runner runner=(Runner)session.getAttribute("runner");
		String runnerName=runner.getName();
		String runnerTel=runner.getTel();
		String runnerId=runner.getId();
		
		String cmsId=request.getParameter("id");
		Commission cms=CmsManager.getCms(cmsId);
		cms.setRunnerInfo(runnerId,runnerName, runnerTel);
		cms.setStatus(-1);
		runner.getCmsList().add(cms);
		response.sendRedirect("commissions.jsp"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
