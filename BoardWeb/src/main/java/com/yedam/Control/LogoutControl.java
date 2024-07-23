package com.yedam.Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;

public class LogoutControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 세션객체의 정보를 삭제하거나, setAttridute("logid", id
		HttpSession session = req.getSession();
		session.invalidate(); //  세션객체의 정보를 삭제
		resp.sendRedirect("loginForm.do"); //클라이언트 리다이렉션: sendRedirect 메서드를 호출하면 클라이언트는 지정된 URL로 이동

	}

}
