<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/style/table.css">
</head>
<c:import url="header"/>
<body>
	<section>
		<h2>게시판</h2>
		<c:choose>
			<c:when test="${empty list }">
				<c:redirect url="service?command=boardlist"></c:redirect>
			</c:when>
			<c:otherwise>
				<table border="1">
					<thead>
						<tr>
							<th>no</th>
							<th>작성자</th>
							<th>제목</th>
							<th>등록일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="board" varStatus="info">
							<tr>
								<td>${list.size() - info.count + 1}</td>
								<td>${board.clientName }</td>
								<td class="title"><a
									href="board?boardCode=${board.boardCode }">${board.title }</a></td>
								<td>${board.regDate }</td>
								<td>${board.modifiedDate }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="button">
					<c:if test="${not empty log }">
						<button onclick="location.href='boardwrite'">글쓰기</button>
					</c:if>
				</div>
			</c:otherwise>
		</c:choose>
	</section>
</body>
<c:import url="footer"/>
</html>