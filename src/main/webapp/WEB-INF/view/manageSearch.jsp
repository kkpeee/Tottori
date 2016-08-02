<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
<title>管理者検索結果</title>
</head>
<body>
<div style="text-align:center">
	<div style="text-align:right"><a href = "reserveBook">戻る</a></div>
<h1>検索一覧</h1>
<h3>${errorMessage}</h3>
<form:form modelAttribute="searchedList" method="GET" action="manageConfilme" >
<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
	<thead>
		<tr>
			<th bgcolor="#99CC00">書名</th>
			<th bgcolor="#99CC00">著者名</th>
			<th bgcolor="#99CC00">出版社名</th>
			<th bgcolor="#99CC00">書類種類</th>
			<th bgcolor="#99CC00">棚番号</th>
			<th bgcolor="#99CC00">貸出状況</th>
			<th bgcolor="#99CC00">予約人数</th>
			<th bgcolor="#99CC00">予約</th>
		</tr>
	</thead>

		<c:forEach items="${searchedList}" var="search">
			<tr>
				<td><c:out value="${search.bookName}" /></td>
				<td><c:out value="${search.authorName}" /></td>
				<td><c:out value="${search.publisher}" /></td>
				<td><c:out value="${search.documentName}" /></td>
				<td><c:out value="${search.shelfId}" /></td>
				<td><c:out value="${search.statusName}" /></td>
				<td><c:out value="${search.bookId}" /></td>
				<td><input type="checkbox" name="bookId" value="${search.bookId}"></td>
    		</tr>
		</c:forEach>
</table><br>
 <input type="submit" value = "予約確認">
</form:form>
</div>
</body>
</html>