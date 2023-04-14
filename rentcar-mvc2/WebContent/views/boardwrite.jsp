<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/style/form.css">
</head>
<c:import url="header" />
<body>
	<c:if test="${empty log }">
		<c:redirect url="login" />
	</c:if>

	<section>
		<h2>글쓰기</h2>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="boardwrite">
			<input type="hidden" name="clientId" value="${log.clientId }">
			<select name="vehicleId">
				<option value="0">--- 이용 내역 ---</option>
				<c:forEach items="${booklist }" var="book">
					<option value="${book.vehicleId }">${book.vehicleId }</option>
				</c:forEach>
			</select>
			<input type="text" name="title" placeholder="제목" required autofocus>
			<input type="file" name="file" >
			<textarea name="contents" rows="20" cols="100" placeholder="내용" required></textarea>
			<input type="submit">
		</form>
	</section>
</body>
<c:import url="footer"></c:import>
</html>