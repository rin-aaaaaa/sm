package com.yedam.Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

/*
 * POJO(plain Old Java Obrject)
 */
public class StudentListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/studentList.jsp")
		.forward(req, resp); // 페이지 재지정

		// stdList.co -> 보여줄 페이지는 WEB-INT/jsp/studentList.jap
//		try {
//			req.getRequestDispatcher("WEB-INF/jsp/studentList.jsp")
//			.forward(req, resp); // 페이지 재지정
//		} catch (ServletException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

}
