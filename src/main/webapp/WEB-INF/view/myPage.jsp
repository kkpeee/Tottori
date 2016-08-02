<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<meta charset="utf-8">
	<title>マイページ</title>
	<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div style="text-align:center">
	<h1>${loginUser.user_name}さんのマイページ</h1>
		<a href="${pageContext.request.contextPath}/reserveBook">検索</a>
		<a href="login">ログアウト</a>

	<c:if test="${ not empty mypageReserves }">
		<h2>予約一覧</h2>
		<form:form modelAttribute="reserveForm" method="POST" action="reserveCancel">
			<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
				<tr>
					<th bgcolor="#99CC00">本の名前</th>
					<th bgcolor="#99CC00">予約日時</th>
					<th bgcolor="#99CC00">キャンセル</th>
				</tr>
				<c:forEach items="${mypageReserves}" var="reserve">
				<tr>
					<td><c:out value="${reserve.book_name}"></c:out></td>
						<td><c:out value="${reserve.reserve_id}"></c:out></td>
						<td><input type="checkbox" name="reserve_id" value="${reserve.reserve_id}"></td>
					</tr>
				</c:forEach>
			</table><br>
			<input type="submit" value="キャンセル" />
			</form:form>
	</c:if>
	<c:if test="${ not empty mypageRentals }">
		<h2>貸出一覧</h2>
			<table class="price">
				<thead>
					<tr>
						<th class="c1">本の名前</th>
						<th class="c2">貸出日時</th>
						<th class="c3">返却日時</th>
					</tr>
					<c:forEach items="${mypageRentals}" var="rental">
					<tr>
						<td class="c1"><c:out value="${rental.bookName}"></c:out></td>
						<td class="c2"><c:out value="${rental.rentalTime}"></c:out></td>
						<td class="c3"><c:out value="${rental.returnTime}"></c:out></td>
					</tr>
					</c:forEach>
				</thead>
			</table>
	</c:if>
</div>
</body>
</html>