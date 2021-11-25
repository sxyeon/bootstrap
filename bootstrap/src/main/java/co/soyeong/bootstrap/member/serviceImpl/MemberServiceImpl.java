package co.soyeong.bootstrap.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.soyeong.bootstrap.member.service.MemberMapper;
import co.soyeong.bootstrap.member.service.MemberService;
import co.soyeong.bootstrap.member.service.MemberVO;

public class MemberServiceImpl implements MemberService{
	private SqlSession sqlSession = co.soyeong.bootstrap.comm.DataSource.getDataSource().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);

	@Override
	public List<MemberVO> memberList() {
		return map.memberList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		return map.memberDelete(vo);
	}

	@Override
	public boolean memberIdOverlap(String id) {
		return map.memberIdOverlap(id);
	}

	@Override
	public int memberAuthorUpdate(MemberVO vo) {
		return map.memberAuthorUpdate(vo);
	}
	
}
