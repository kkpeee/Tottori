<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta charset="utf-8">
		<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
		<title>返却確認画面</title>
	</head>
	<body>
<div style="text-align:center">
	<div style="text-align:right"><a href = "returnBook">戻る</a></div>
	<h1>返却確認画面</h1>

	<c:forEach items = "${ messages }" var = "message">
		<li><c:out value = "${ message }" /><br>
	</c:forEach>

			<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
				<tr>
					<th bgcolor="#99CC00">書名</th>
					<th bgcolor="#99CC00">著者名</th>
					<th bgcolor="#99CC00">出版社</th>
					<th bgcolor="#99CC00">書類種類</th>
				</tr>
				<c:forEach items="${ReturnList}" var="returnList">
					<tr>
						<td><c:out value="${returnList.bookName}"></c:out></td>
						<td><c:out value="${returnList.authorName}"></c:out></td>
						<td><c:out value="${returnList.publisher}"></c:out></td>
						<td><c:out value="${returnList.documentName}"></c:out></td>
					</tr>
				</c:forEach>
			</table><br/>
		<a href = "returnConfirm"><button >返却</button></a>
</div>
	</body>
</html>