package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.util.List;
import java.net.URLDecoder;
import java.io.File;

/**
 * Servlet implementation class ImageHand
 */
@WebServlet("/ImageHand")
public class ImageHand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	File tempFile;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageHand() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		System.out.println("图片存放");
	    request.setCharacterEncoding("UTF-8");
	    
	    boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	    if (isMultipart)
	    {
	      //String dir = "/Users/demon/imageTest"; //for mac
	      String dir = "/usr/images";  //for linux
	      
	      File dirFile = new File(dir);
	      if (!dirFile.exists()) {
	        dirFile.mkdirs();
	      }
	      try
	      {
	        FileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload fileUpload = new ServletFileUpload(factory);
	        
	        List<FileItem> items = fileUpload.parseRequest(request);
	        for (FileItem item : items) {
	          if (item.isFormField())
	          {
	        	  
	            String name = item.getFieldName();
	            System.out.println(name+" "+URLDecoder.decode(item.getString(), "utf-8"));
	           
	          }
	          else
	          {	
	
	              System.out.println(dir);
	              System.out.println("item.getName=" + item.getName());
	              String longFileName = item.getName();
	              System.out.println("longFileName:" + longFileName);
	              char indexChar = '/';
	              String fileName = item.getName().substring(longFileName.lastIndexOf(indexChar) + 1, longFileName.length());
	              System.out.println("filePath=" + dir + "/" + fileName);
	              File saveFile = new File(dirFile, fileName);
	              item.write(saveFile);
	            
 
	          }
	        }
	        
	      }
	      catch (Exception e)
	      {
	        e.printStackTrace();
	      }
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
