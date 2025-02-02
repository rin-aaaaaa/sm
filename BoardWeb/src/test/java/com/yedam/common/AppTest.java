package com.yedam.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class AppTest {
	public static void main(String[] args) {
		//차트
		MemberService svc = new MemberServiceImpl();
		List<Map<String, Object>> list = svc.getCountByMember();
		for(Map<String, Object> map : list) {
			System.out.println("===================");
			Set<String> keyset = map.keySet();
			for(String key : keyset) {
				System.out.println(key + ", " + map.get(key));
			}
		}
		
		System.out.println("=END=");
		
		
		
//		// Reply 페이징 테스트
//		ReplyService svc = new ReplyServiceImpl();
//		
//		SearchVO search = new SearchVO();
//		search.setBno(148);
//		search.setPage(3);
//		
//		svc.replyList(search).forEach(System.out::println);
//		System.out.println("- End -");
		
		
		
//		// Reply
//		//테스트용
//	        ReplyService svc = new ReplyServiceImpl();
//
//	        ReplyVO rvo = new ReplyVO();
//	        rvo.setReplyContent("등록연습");
//	        rvo.setReplyer("user03");
//	        rvo.setBoardNo(147);
//
//	        if (svc.addReply(rvo)) {
//	            System.out.println("완");
//	        }
//
//	        svc.replyList(148).forEach(System.out::println);
//
//	        System.out.println("-End-");
		
		
		
//		//서치값
//		BoardService svc = new BoardServiceImpl();
//		SearchVO serach = new SearchVO();
//		serach.setSearchCondition("W");
//		serach.setKeyword("test");
//		serach.setPage(1);
//		
//		svc.boardList(serach).forEach(System.out::println);
//		System.out.println("- END -");
		
		//페이지로 출력
//		BoardService svc = new BoardServiceImpl();
//		svc.boardList(5).forEach(System.out::println);
//		System.out.println("- END -");

		// 세션접속
//		SqlSession sqlsession = DataSource.getInstance().openSession(true); // true자동커밋
//		StudentMapper mapper = sqlsession.getMapper(StudentMapper.class);
//		mapper.studentList().forEach(student -> {System.out.println(student);});

		// 메퍼선언?
//		BoardMapper mapper = sqlsession.getMapper(BoardMapper.class);

		// 업데이트
//		BoardVO brd = new BoardVO();
//		brd.setTitle("매퍼테스트222");
//		brd.setContent("조건이 제대로 되는지22");
//		brd.setWriter("newbie");
//		brd.setBoardNo(4);

		// 업데이트
//		if(mapper.updateBoard(brd) == 1) {
//			System.out.println("OK");
//		}

//		if (mapper.deleteBoard(5) == 1) {
//			System.out.println("OK");
//		}

//		System.out.println(mapper.selectBoard(4));
		
//		System.out.println(mapper.deleteBoard(1));
		

		// 출력
//		mapper.selectList().forEach(board -> System.out.println(board.toString()));

		
//		// 서비스 가져오기
//		BoardService svc = new BoardServiceImpl();
//		svc.boardList().forEach(System.out::println);
//		System.out.println("- END -");

	}
}
