<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予約確認</title>
</head>
<body>
<div style="text-align:center">
	<div style="text-align:right"><a href = "reserveBook">戻る</a></div>
	<h1>予約確認画面</h1>
	<c:forEach items = "${ messages }" var = "message">
		<li><c:out value = "${ message }" /><br>
	</c:forEach>

    <div><form:errors path="*"  /></div>
<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
	<thead>
		<tr>
			<th bgcolor="#99CC00">書名</th>
			<th bgcolor="#99CC00">著者名</th>
			<th bgcolor="#99CC00">出版社名</th>
			<th bgcolor="#99CC00">書類種類</th>
			<th bgcolor="#99CC00">保管図書館</th>

		</tr>
	</thead>

		<c:forEach items="${checkedList}" var="cheack">
			<tr>
				<td><c:out value="${cheack.bookName}" /></td>
				<td><c:out value="${cheack.authorName}" /></td>
				<td><c:out value="${cheack.publisher}" /></td>
				<td><c:out value="${cheack.documentName}" /></td>
				<td><c:out value="${cheack.libraryName}" /></td>
    		</tr>
		</c:forEach>
</table>
	<h3>${errorMessage}</h3>
	<h3>${message}</h3>
	<c:forEach items="${reserveBook}" var="reserveBook">
		<c:out value="${reserveBook.bookName}" /><br>
	</c:forEach>
<form:form modelAttribute="reserveForm"><br>
	        <tr>
		        <td bgcolor="#99CC00" >ユーザーID</td>
		        <td><input name = "userId"/></td>
		    </tr>
<input type="submit" value = "予約">
</form:form>
</div>
</body>
</html>