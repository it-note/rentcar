<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/style/form.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js" integrity="sha512-E8QSvWZ0eCLGk4km3hxSsNmGWbLtSCSUcewDQPQWZF6pEU8GlT8a5fF32wOl1i8ftdMhssTrF/OhyGWwonTcXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<jsp:include page="header" />
<body>
	<section>
		<h2>로그인</h2>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="updatelog">
			<input type="text" id="id" name="id" value="${param.id}" placeholder="id" ${empty param.id ? "autofocus" : ""} required> 
			<input type="password" id="password" name="password" placeholder="password" ${not empty param.id ? "autofocus" : ""} required> 
			<input type="button" value="로그인" onclick="checkForm(form)">
		</form>
	</section>
	<script src="../resources/script/login.js"></script>
</body>
<jsp:include page="footer" />
</html>