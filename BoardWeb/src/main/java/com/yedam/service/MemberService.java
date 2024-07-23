package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;

public interface MemberService {
	MemberVO loginCheck(String id, String pw);

	List<MemberVO> memberList(String res, String order);
	

}
