package co.soyeong.bootstrap.member.commamd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.soyeong.bootstrap.comm.Command;
import co.soyeong.bootstrap.member.service.MemberService;
import co.soyeong.bootstrap.member.service.MemberVO;
import co.soyeong.bootstrap.member.serviceImpl.MemberServiceImpl;

public class LoginCheck implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//로그인 처리
		MemberService memberDao = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member = memberDao.memberSelect(member);
		String viewPage = null;
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", member.getId());
			session.setAttribute("name", member.getName());
			session.setAttribute("author", member.getAuthor());
			viewPage = "main.do";
		}else {
			viewPage = "main/login";
		}
		return viewPage;
	}

}
