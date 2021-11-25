package co.soyeong.bootstrap.notice.service;

import java.util.List;

public interface NoticeService {
	
	List<NoticeVO> noticeList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	List<NoticeVO> noticeSearchList(String searchKey);
}
