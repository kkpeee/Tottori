<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
<title>ユーザー管理</title>
</head>
<body>
<div style="text-align:center">
	<div style="text-align:right"><a href = "home">戻る</a></div>
	<h1>ユーザー管理画面</h1>
<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
	<tr>
		<th bgcolor="#99CC00">ユーザーID</th>
		<th bgcolor="#99CC00">名前</th>
		<th bgcolor="#99CC00">アドレス</th>
		<th bgcolor="#99CC00">メール</th>
		<th bgcolor="#99CC00">電話番号</th>
		<th bgcolor="#99CC00">受取図書館ID</th>
		<th bgcolor="#99CC00">登録日時</th>
		<th bgcolor="#99CC00">更新日時</th>
	</tr>
	<c:forEach items = "${ Users }" var = "user">
	<tr>
		<td><c:out value = "${ user.userId }" /></td>
		<td><c:out value = "${ user.userName }" /></td>
		<td><c:out value = "${ user.address }" /></td>
		<td><c:out value = "${ user.mail }" /></td>
		<td><c:out value = "${ user.phoneNumber }" /></td>
		<td><c:out value = "${ user.libraryId }" /></td>
		<td><fmt:formatDate value = "${ user.insertTime }" pattern = "yyyy-MM-dd HH:mm:ss" /></td>
		<td><fmt:formatDate value = "${ user.updateTime }" pattern = "yyyy-MM-dd HH:mm:ss" /></td>
	</c:forEach>
</table><br>
<form:form modelAttribute="userForm">
	ユーザーID：<input name = "userId"/> 更新日時：<input name = "date"/> <input type="submit" value = "変更"/>
</form:form>
</div>
</body>
</html>