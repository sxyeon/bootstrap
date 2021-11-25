package co.soyeong.bootstrap.comm;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.soyeong.bootstrap.comm.main.Buttons;
import co.soyeong.bootstrap.main.Login;
import co.soyeong.bootstrap.main.MainCommand;
import co.soyeong.bootstrap.member.commamd.LoginCheck;
import co.soyeong.bootstrap.member.commamd.Logout;
import co.soyeong.bootstrap.notice.command.NoticeList;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/noticeList.do", new NoticeList());
		map.put("/buttons.do", new Buttons());//button.jsp호출
		map.put("/login.do", new Login());//로그인 화면 호출
		map.put("/loginCheck.do", new LoginCheck());//로그인 화면 호출
		map.put("/logout.do", new Logout());//로그out
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.run(request, response);
		
		//들어오 경우는 총 4가지 있음
		if(!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(viewPage.substring(5));
				return;
			}
			if(viewPage.endsWith(".jsp")) {
				//타일즈를 사용해서 템블릿을 씌워서 보내기 싫을경우
				viewPage = "WEB-INF/views/"+viewPage;
			}
			viewPage = viewPage+".tiles"; //타일즈 레이아웃 사용
			//이미 설정에서 WEB-INF/views/을 해주었기 때문에 따로 할 필요가 없음
		}
		
		RequestDispatcher requestDispatcher  = request.getRequestDispatcher(viewPage);
		requestDispatcher.forward(request, response);
	}

}
