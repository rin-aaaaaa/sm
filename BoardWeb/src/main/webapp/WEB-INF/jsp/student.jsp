<%@page import="com.yedam.vo.StudentVO"%>
<%@page import="com.yedam.mapper.StudentMapper"%>
<%@page import="com.yedam.common.DataSource"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student.jsp</title>
</head>
<body>
<%
 SqlSession sqlSession = DataSource.getInstance().openSession(true);
 StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
 String sao = request.getParameter("sno"); //?sno=s2024-02
 StudentVO std = mapper.selectOne(sao);		 
 %>
 <h3> 학생상세보기 </h3>
 <table border="2">
 	<tr>
 	<th> 학생번호 </th><td><%=std.getStdNo() %></td></tr>
 	<tr>
 	<th> 이름 </th><td><%=std.getStdName() %></td></tr>
 	<tr>
 	<th> 연락처 </th><td><%=std.getStdPhone() %></td></tr>
 	<tr>
 	<th> 생일 </th><td><%=std.getBirthDate() %></td></tr>
 	<tr>
 	<th> 주소</th><td><%=std.getAddress() %></td></tr>
 </table>
 <a href="../SampleServlet"> 목록으로 </a>
</body>
</html>