package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
import net.sf.json.JSONObject;
 
import org.apache.commons.*;





public class ImageTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uploadFilePath = "/Users/demon/imageTest";
	File tempFile;
 
   
    public ImageTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("图片存放");
	    request.setCharacterEncoding("UTF-8");
	    
	    boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	    if (isMultipart)
	    {
	      String dir = "/Users/demon/imageTest";
	      
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
	              char indexChar = '\\';
	              String fileName = item.getName().substring(longFileName.lastIndexOf(indexChar) + 1, longFileName.length());
	              System.out.println("filePath=" + dir + "\\" + fileName);
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
		doGet(request, response);



        
	}

   // @RequestMapping(value = "/upload/uploadPic", method = {RequestMethod.POST, RequestMethod.GET})
    //public ModelAndView uploadPicture(HttpServletRequest request, HttpServletResponse response) throws IOException {
 
       // MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
    	
    	
   // }

}
