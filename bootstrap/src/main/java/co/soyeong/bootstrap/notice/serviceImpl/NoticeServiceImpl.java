package co.soyeong.bootstrap.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.soyeong.bootstrap.comm.DataSource;
import co.soyeong.bootstrap.notice.service.NoticeMapper;
import co.soyeong.bootstrap.notice.service.NoticeService;
import co.soyeong.bootstrap.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService{
	private SqlSession sqlSession = DataSource.getDataSource().openSession(true);
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
			
	@Override
	public List<NoticeVO> noticeList() {
		return map.noticeList();
	}
	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}
	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}
	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}
	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}
	@Override
	public List<NoticeVO> noticeSearchList(String searchKey) {
		return map.noticeSearchList(searchKey);
	}

}