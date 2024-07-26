package com.yedam.Control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		// retCode: Success, retCode: Fail
		String rno = req.getParameter("rno"); //removeReply.do?rno=
		ReplyService svc = new ReplyServiceImpl();
		
		Map<String, Object> map = new HashMap<>();

		try {
			if (svc.removeReply(Integer.parseInt(rno))) {
				map.put("retCode", "Success");
			}
		} catch (Exception e) {
			// e.printStackTrace(); //오류찾을때
			map.put("retCode", "Fail");
		}
		// json문자열 생성.
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);

		resp.getWriter().print(json);
	}

}
