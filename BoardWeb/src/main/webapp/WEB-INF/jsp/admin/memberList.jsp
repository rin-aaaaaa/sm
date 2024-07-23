<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3> 회원목록 </h3>
<table class="table table-dark table-striped">
	<thead>
		<tr>
		  <th scope="col">#</th>
			<th scope="col"><a href="memberList.do?order=member_id">아이디</a></th>
			<th scope="col">패스워드</th>
			<th scope="col"><a href="memberList.do?order=member_nm">이름</a></th>
			<th scope="col">권한</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="member" items="${memberList }" varStatus="stat">
			<tr>
				<th scope="row">${stat.count}</th>
				<td>${member.memberId}</td>
				<td>${member.memberPw }</td>
				<td>${member.memberNm }</td>
				<td>${member.responsibility }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>