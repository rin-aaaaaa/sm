package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.ReplyVO;

public interface ReplyService {

    List<ReplyVO> replyList(SearchVO search); // 댓글목록
    boolean addReply(ReplyVO rvo); // 댓글등록
    boolean removeReply(int replyNo); // 댓글삭제
	int replyToralCnt(int boardNO);// 댓글갯수
	
}// end interface