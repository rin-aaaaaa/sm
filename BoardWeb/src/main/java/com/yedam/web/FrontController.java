package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Control.ActionControl;
import com.yedam.Control.AddBoardControl;
import com.yedam.Control.AddReplyControl;
import com.yedam.Control.AddStudent;
import com.yedam.Control.BoardControl;
import com.yedam.Control.BoardForm;
import com.yedam.Control.BoardListControl;
import com.yedam.Control.CntByMember;
import com.yedam.Control.DeleteBoard;
import com.yedam.Control.GoogleChart;
import com.yedam.Control.ImageDownLoad;
import com.yedam.Control.LoginControl;
import com.yedam.Control.LoginForm;
import com.yedam.Control.LogoutControl;
import com.yedam.Control.MemberListControl;
import com.yedam.Control.ModifyBoard;
import com.yedam.Control.PagingCount;
import com.yedam.Control.RemoveBoard;
import com.yedam.Control.RemoveReplyControl;
import com.yedam.Control.RemoveStudent;
import com.yedam.Control.ReplyListControl;
import com.yedam.Control.ScriptControl;
import com.yedam.Control.StudentListControl;
import com.yedam.Control.StudentJson;
import com.yedam.Control.UpdateBoard;
import com.yedam.common.Control;

/*
 * FrontController역할은 사용자의 모드 요청을 처리
 * 서블릿, a.do, sample.do
 * 객체생성 -> init -> servlet -> destroy
 */
public class FrontController extends HttpServlet {

	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 글 등록 구현 : 등록화면(boardForm) + DB등록(addBoard.co) -> 글 목록페이지 이동
		map.put("/boardList.do", new BoardListControl());
		map.put("/boardForm.do", new BoardForm());
		map.put("/addBoard.do", new AddBoardControl());
		// 학색목록
		map.put("/stdList.do", new StudentListControl());
		// 상세화면?
		map.put("/board.do", new BoardControl());
		// 삭제
		map.put("/removeBoard.do", new RemoveBoard());
		map.put("/deleteBoard.do", new DeleteBoard());
		// 수정
		map.put("/modifyBoard.do", new ModifyBoard());
		map.put("/updateBoard.do", new UpdateBoard());

		// 태그연습
		map.put("/action.do", new ActionControl());

		// 로그인
		map.put("/loginForm.do", new LoginForm()); // 로그인 화면 open
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());

		// 관리자가 사용하는 기능들 ex)회원목록
		map.put("/memberList.do", new MemberListControl());

		// 자바스크립트 연슨 페이지 호충
		map.put("/javascript.do", new ScriptControl());

		// 학생정보 반환해주는 페이지(json
		map.put("/studentJson.do", new StudentJson());

		// 학생정보(학번기준) 삭제해주는 페이지
		map.put("/removeStudent.do", new RemoveStudent());
		
		// 등록
		map.put("/addStudent.do", new AddStudent());
		
		
		
		// 목록
		map.put("/replyList.do", new ReplyListControl());
		// 등록
		map.put("/addReply.do", new AddReplyControl());
		// 삭제
		map.put("/removeReply.do", new RemoveReplyControl());
		
		// 페이징
		map.put("/pagingCount.do", new PagingCount());
		
		// 이미지 다운로드
		map.put("/imageDownload.do", new ImageDownLoad());
		
		
		// 차트(작성자별 게시건수)
		map.put("/countByMember.do", new CntByMember());
		// 차트페이지
		map.put("/googleChart.do", new GoogleChart());
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// boardList.do -목록. addboard.do -등록
		String uri = req.getRequestURI(); // URL(http://localhoet/BoardWeb/boardList.do)
											// va.URI(BoardWeb/boardList.do이부분만)
		String context = req.getContextPath(); // 프로젝트 명
		String path = uri.substring(context.length()); // "boardList.do"/

		System.out.println(path);
		Control sub = map.get(path);
		sub.exec(req, resp);
	}
}
