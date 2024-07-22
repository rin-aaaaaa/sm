<%@page import="com.yedam.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- 변수값은 읽어오는 방법이 다름2 -->
<html>
<head>
<meta charset="UTF-8">
<title>actionForm.jsp</title>
</head>
<body>
	<h3>액션태그연습</h3>
	<%
	request.setAttribute("myName", "홍길동");
	StudentVO student = new StudentVO();
	student.setStdNo("100");
	student.setStdName("홍길동");
	
	request.setAttribute("student", student);
	String msg = "Hello";
	%>
	<!-- 위 prefix="c" c가 테그이름 태그이름 :set -->
	<c:set var="msg" value="Hello2"> </c:set> <!-- 이렇게 쓴다3 -->
	<c:set var="age" value="20" />
	
	<h3>Jsp Standard Tag Library & Expression Language</h3>
	<p>${10+4 }</p>
	<p>${10 > 20 }</p>
	<p>${'Hello' += 'World' }</p>
	<p>${10 > 5 ? '참' : '거짓' }</p>
	<p>이름은 ${myName}</p>
	<p>학생정보 ${student}</p>
	<p>학생이름은 ${student.stdName}, 학번은 ${student.stdNo}</p>
	<p>Msg 값은 ${msg}</p> <!-- 변수값은 읽어오는 방법이 다름1 -->
	<p>${age >= 20 ? '성인' : '미성년'}</p>
	
	<c:if test="%{age > 20 }">
		<p>성인</p>
	</c:if>
	
	<c:choose>
		<c:when test="%{age >= 20">
			<p>성인</p>
		</c:when>
		<c:otherwise>
			<p>미성년</p>
		</c:otherwise>
	</c:choose>
			
	<c:forEach var="i" begin="1" end="10" step="2"> 
		<p>${i }</p>
	</c:forEach> <!-- 반복문 -->
	
	<p>구구단 4단 출력</p>
		<c:forEach var="n" begin="1" end="9"> 
		<p> 4 * ${n} = ${4*n} </p>
	</c:forEach>
</body>
</body>
</html>