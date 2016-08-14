package uy.com.amensg.claro.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import uy.com.amensg.claro.util.Configuration;

@MultipartConfig(
	fileSizeThreshold=1024*1024*10,	// 10 MB
	maxFileSize=1024*1024*50,		// 50 MB
	maxRequestSize=1024*1024*100	// 100 MB
)
public class UploadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1408929564540370839L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String caller = request.getParameter("caller");
		
		try {
			if (caller.contains("mobile")) {
				
			} else {
				String fileName = null;
				for (Part part : request.getParts()) {
					String contentDisposition = part.getHeader("content-disposition");
					
					String[] tokens = contentDisposition.split(";");
			        for (String token : tokens) {
			        	if (token.trim().startsWith("filename")) {
		            		fileName = token.substring(token.indexOf("=") + 2, token.length()-1);
		            		break;
		            	}
			        }
			        
			        if (fileName != null) {
			        	part.write(Configuration.getInstance().getProperty("importacion.carpeta") + fileName);
			        	break;
			        }
				}
				
				String json = "{"
					+ "\"fileName\": \"" + fileName
					+ "}";
				
				response.addHeader("Content-Type", "application/json");
				response.getWriter().write(json);
				response.getWriter().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			String json = "{"
				+ "\"message\": \"No se ha podido completar la operación.\""
				+ "}";
			
			response.addHeader("Content-Type", "application/json");
			response.getWriter().write(json);
			response.getWriter().close();
		}
	}
}