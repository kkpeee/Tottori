<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
<title>未返却の図書</title>
</head>
<body>
	<div style="text-align:center">
	<div style="text-align:right"><a href = "home">戻る</a></div>
	<h1>返却されていない本</h1>
<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
	<tr>
		<th bgcolor="#99CC00">名前</th>
		<th bgcolor="#99CC00">書名</th>
 		<th bgcolor="#99CC00">貸出日</th>
		<th bgcolor="#99CC00">経過日数</th>
	</tr>
	<c:forEach items = "${ RentalBook }" var = "rentalBook">
		<tr>
			<td><c:out value = "${ rentalBook.userName }" /></td>
 			<td><c:out value = "${ rentalBook.bookName }" /></td>
			<td><fmt:formatDate value = "${ rentalBook.rentalTime }" pattern = "yyyy年MM月dd日"/></td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>