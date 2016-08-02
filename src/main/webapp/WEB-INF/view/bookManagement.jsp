<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>貸出管理</title>
<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div style="text-align:center">
	<div style="text-align:right"><a href = "home">戻る</a></div>
	<h1>書籍管理画面</h1>
	<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
	<tbody>
		<tr>
			<th bgcolor="#99CC00">図書名</th>
			<th bgcolor="#99CC00">著者名</th>
			<th bgcolor="#99CC00">出版社</th>
			<th bgcolor="#99CC00">ISBN</th>
			<th bgcolor="#99CC00">棚番号</th>
			<th bgcolor="#99CC00">書類種類</th>
			<th bgcolor="#99CC00">保管図書館</th>
			<th bgcolor="#99CC00">状態</th>
		</tr>
	<c:forEach items = "${ Books }" var = "book">
		<tr>
			<td><c:out value = "${ book.bookName }" /></td>
			<td><c:out value = "${ book.authorName }" /></td>
			<td><c:out value = "${ book.publisher }" /></td>
			<td><c:out value = "${ book.isbn }" /></td>
			<td><c:out value = "${ book.shelfId }" /></td>
			<td><c:out value = "${ book.documentId }" /></td>
			<td><c:out value = "${ book.libraryId }" /></td>
			<td><c:out value = "${ book.statusId }" /></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
<br>
	<h1>貸出一覧</h1>
<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
	<tr>
		<th bgcolor="#99CC00">ユーザー名</th>
		<th bgcolor="#99CC00">図書名</th>
		<th bgcolor="#99CC00">ISBN</th>
		<th bgcolor="#99CC00">貸出日</th>
	<c:forEach items = "${ Rental }" var = "rental">
	<tr>
		<td><c:out value = "${ rental.userName }" /></td>
		<td><c:out value = "${ rental.bookName }" /></td>
		<td><c:out value = "${ rental.isbn }" /></td>
		<td><fmt:formatDate value = "${ rental.rentalTime }" pattern = "yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
	</c:forEach>
</table><br>
	<form:form modelAttribute="rentalForm">
		ユーザーID：<input name = "userId" /> ISBN：<input name = "useIsbn" />
		保管図書館：<input name = "libraryId" /> 更新日時：<input name = "date"/>
		<input type="submit" value = "変更"/>
	</form:form>
</div>
</body>
</html>