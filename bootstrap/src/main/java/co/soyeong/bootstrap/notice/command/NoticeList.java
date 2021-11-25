package co.soyeong.bootstrap.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.soyeong.bootstrap.comm.Command;
import co.soyeong.bootstrap.notice.service.NoticeService;
import co.soyeong.bootstrap.notice.serviceImpl.NoticeServiceImpl;

public class NoticeList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//공지사항 처리
		NoticeService noticeDao = new NoticeServiceImpl();
		request.setAttribute("notices", noticeDao.noticeList());
		return "notice/noticeList";
	}

}
