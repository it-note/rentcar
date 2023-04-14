<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/style/form.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js" integrity="sha512-E8QSvWZ0eCLGk4km3hxSsNmGWbLtSCSUcewDQPQWZF6pEU8GlT8a5fF32wOl1i8ftdMhssTrF/OhyGWwonTcXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<jsp:include page="header" />
<body>
	<section>
		<h2>회원가입</h2>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="join">
			<input type="hidden" id="key" name="key" value="">
			
			<div>
			<input type="text" id="id" name="id" placeholder="아이디" value="${param.id}" ${empty param.id ? "autofocus" : ""} }>
			<input type="button" value="중복확인" onclick="checkDuplId()">
			</div>
			<p id="msg"></p>
			<input type="password" id="password" name="password" placeholder="비밀번호" ${empty param.password ? "autofocus" : ""}>
			<input type="password" id="password2" name="password2" placeholder="비밀번호">
			<input type="text" id="name" name="name" placeholder="이름" value="${param.name}">
			<input type="text" id="phone" name="phone" placeholder="연락처" value="${param.phone}">
			<p id="msg-phone"></p>
			<div>
			<input type="text" id="zonecode" name="zonecode" readonly value="${param.zonecode}">
			<input type="button" value="우편번호" onclick="searchZonecode()">
			</div>
			<input type="text" id="address" name="address" placeholder="주소" readonly value="${param.address}">
			<input type="text" id="subaddress" name="subaddress" placeholder="상세주소" value="${param.subaddress}">
			
			<input type="button" value="가입" onclick="checkValues(form)">
		</form>
	</section>
</body>
<script src="../resources/script/validation.js"></script>
<jsp:include page="footer" />
</html>