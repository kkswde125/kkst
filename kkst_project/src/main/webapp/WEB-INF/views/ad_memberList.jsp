<%@page import="com.pro.kkst.dtos.LoginDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function allChk(bool){
		$("input[name=chk]").prop("checked", bool);
	}
</script>

<body>

<%
// 	List<LoginDto> lists = (List<LoginDto>)request.getAttribute("lists");
%>
<h1>가입 회원 목록</h1>
<form action="ad_memDel.do" method="post">
<table border = "1">
	<thead>
		<tr>
			<td>
				<input type="checkbox" name="allChk" onclick="allChk(this.checked)"/>
			</td>
			<td>ID</td>
			<td>별명</td>
			<td>이름</td>
			<td>성별</td>
			<td>생년월일</td>
			<td>이메일</td>
			<td>탈퇴여부</td>
		</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${empty lists }">
			<tr>
				<td>
					<input type="checkbox" disabled="disabled"/>
				</td>
				<td colspan="7">===== 가입된 회원이 없습니다 =====</td>
			</tr>
		</c:when>
		<c:otherwise>
		<c:forEach items="${lists}" var="dto">
			<tr>
			<td>
				<input type="checkbox" name="chk" value="${dto.seq }"/>
			</td>
			<td>${dto.id }</td>
			<td>${dto.nickName }</td>
			<td>${dto.name }</td>
			<c:choose>
				<c:when test="${dto.sex=='F'}">
					<td>여성</td>
				</c:when>
				<c:otherwise>
					<td>남성</td>
				</c:otherwise>
				</c:choose>
			<td><fmt:formatDate value="${dto.birth }" pattern="yyyy년 MM월 dd일"/> </td>
			<td>${dto.email }</td>
			<c:choose>
				<c:when test="${dto.delFlag=='N'}">
					<td>활동 중</td>
				</c:when>
				<c:otherwise>
					<td>탈퇴</td>
				</c:otherwise>
				</c:choose>
		</tr>
		</c:forEach>
		</c:otherwise>
	</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2">
				<input type="button" value="돌아가기" onclick="location.href='ad_admin.do'"/>
			</td>
			<td colspan="5">
				<!-- 페이징 -->
			</td>
			<td>
				<input type="submit" value="강제탈퇴"/>
			</td>
		</tr>
	</tfoot>
</table>
</form>
</body>
</html>