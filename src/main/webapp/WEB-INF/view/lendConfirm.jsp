<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
	<title>貸出確認画面</title>
</head>
<body>
	<div style="text-align:center">
	<div style="text-align:right"><a href = "lendBook">戻る</a></div>
	<h1>貸出確認画面</h1>
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
				<c:forEach items="${LendList}" var="lend">
					<tr>
						<td><c:out value="${lend.bookName}"></c:out></td>
						<td><c:out value="${lend.authorName}"></c:out></td>
						<td><c:out value="${lend.publisher}"></c:out></td>
						<td><c:out value="${lend.documentName}"></c:out></td>
					</tr>
				</c:forEach>
			</table><br/>
		<a href = "lendConfirm"><button>貸出</button></a>
	</div>
	</body>
</html>