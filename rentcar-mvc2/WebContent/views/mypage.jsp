<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<jsp:include page="header" />
<body>
	<c:choose>
		<c:when test="${empty log }">
			<c:redirect url="login" />
		</c:when>
		<c:otherwise>
			<section>
				<h2>예약내역</h2>
			</section>
		</c:otherwise>
	</c:choose>

</body>
<jsp:include page="footer" />
</html>