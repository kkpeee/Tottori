<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<meta charset="utf-8">
	<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
	<title>ブラックリスト</title>
</head>
<body>
<div style="text-align:center">
	<div style="text-align:right"><a href = "home">戻る</a></div>
	<h1>延滞者画面</h1>
	<c:forEach items = "${ messages }" var = "message">
		<li><c:out value = "${ message }" /><br>
	</c:forEach>

    	<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
			<tr>
				<th bgcolor="#99CC00">名前</th>
				<th bgcolor="#99CC00">書名</th>
				<th bgcolor="#99CC00">電話番号</th>
				<th bgcolor="#99CC00">メール</th>
			</tr>
			<c:forEach items="${blackList}" var="blackList">
				<tr>
					<td><c:out value="${blackList.user_name}"></c:out></td>
					<td><c:out value="${blackList.book_name}"></c:out></td>
					<td><c:out value="${blackList.address}"></c:out></td>
					<td><c:out value="${blackList.mail}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
</div>
</body>
</html>