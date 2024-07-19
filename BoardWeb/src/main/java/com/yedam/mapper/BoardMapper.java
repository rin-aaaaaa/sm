package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;

// 글목록, 등록, 수정, 삭제, 단건조회
// 기능정의 -> 기능구현 (BoardMapper.xml)
public interface BoardMapper {
	List<BoardVO> selectList();
//	List<BoardVO> selectListPaging(int page); //페이지정보 -> 5건씩 출력
	List<BoardVO> selectListPaging(SearchVO search); //페이지정보 -> 5건씩 출력
	
	// 페이징 계산하기 위한 전체 건수
	int selectTotalCount(SearchVO search);
	int insertBoard(BoardVO board);
	int updateBoard(BoardVO board);
	int deleteBoard(int boardNo);
	BoardVO selectBoard(int boardNo);
} 
