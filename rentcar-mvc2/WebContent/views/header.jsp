<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon"
	href="https://em-content.zobj.net/source/skype/289/oncoming-automobile_1f698.png">
<link rel="stylesheet" href="../resources/style/grid.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<title>RentCar</title>
</head>
<body>
	<header>
		<div>
			<ul>
				<li><c:choose>
						<c:when test="${empty log }">
							<a href="login">로그인</a>
						</c:when>
						<c:otherwise>
							<a href="../service?command=updatelog">로그아웃</a>
						</c:otherwise>
					</c:choose></li>

				<li><a href="join">회원가입</a></li>
				<li><a href="mypage">마이페이지</a></li>
			</ul>
		</div>
		<h1>
			<a href="/">렌트카</a>
		</h1>
	</header>
	<nav>
		<ul>
			<li><a href="list">단기렌트</a></li>
			<li><a href="inform">공지사항</a></li>
			<li><a href="boardlist">게시판</a></li>
			<li><a href="mypage">마이페이지</a></li>
		</ul>
	</nav>
</body>
</html>