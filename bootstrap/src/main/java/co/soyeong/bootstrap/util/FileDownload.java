package co.soyeong.bootstrap.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileDownload() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String oFileName = request.getParameter("oFileName"); //실제파일명
		String pFileName = request.getParameter("pFileName"); //물리적인 파일명
		
		InputStream in = null; 
		OutputStream out = null;
		File file = null;

		try {
			//input
			file = new File(pFileName); 
			in = new FileInputStream(file); 

			oFileName = new String(oFileName.getBytes("UTF-8"), "ISO-8859-1");
			
			response.setHeader("Content-Disposition", "attachment;filename="+oFileName);

			//output
			out = response.getOutputStream(); 
			byte [] b = new byte[(int)file.length()];
			int length = 0;
			while((length = in.read(b))>0) {
				out.write(b,0,length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
