package co.soyeong.bootstrap.member.service;

import java.util.List;

public interface MemberMapper {
	List<MemberVO> memberList();
	MemberVO memberSelect(MemberVO vo);//login,조회
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	boolean memberIdOverlap(String id);
	int memberAuthorUpdate(MemberVO vo);
}
