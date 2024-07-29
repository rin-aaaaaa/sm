package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchVO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

/*
 * 인터페이스에(BoardService)를 구현하는 구현객체
 * 인터페이스에 정의된 메소드를 다 구현해야함
 */
public class BoardServiceImpl implements BoardService{
	
	SqlSession sqlsession = DataSource.getInstance().openSession(true); // 세션접속.true자동커밋
	BoardMapper mapper = sqlsession.getMapper(BoardMapper.class); // 메퍼선언?

//	@Override
//	public List<BoardVO> boardList() {
//		return mapper.selectList();
//	}
//	@Override
//	public List<BoardVO> boardList(int page) {
//		return mapper.selectListPaging(page);
//	}
	
	@Override
	public List<BoardVO> boardList(SearchVO search) {
		return mapper.selectListPaging(search);
	}

	@Override
	public int totalCount(SearchVO search) {
		return mapper.selectTotalCount(search);
	}
	
	@Override
	public boolean addBoard(BoardVO board) {
		return mapper.insertBoard(board) == 1;
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		return mapper.updateBoard(board) == 1;
	}

	@Override
	public boolean removeBoard(int boardNO) {
		return mapper.deleteBoard(boardNO) == 1;
	}

	@Override
	public BoardVO getBoard(int boardNO) {
		return mapper.selectBoard(boardNO);
	}



}
