<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
<title>ユーザー検索</title>
</head>
<body>
	<div style="text-align:center">
	<div style="text-align:right"><a href = "home">戻る</a></div>
	<h1>ユーザー検索画面</h1>

	<p><c:forEach items = "${ messages }" var = "message">
		<font color = "red"><c:out value = "${ message }" /></font>
		</c:forEach>
	</p>

    <form:form modelAttribute="userForm" method = "get" action="userUpdate">
        <div><font color = "red"><form:errors path="*"  /></font></div>
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
    		<tr>
		        <td bgcolor="#99CC00" >ユーザーID</td>
		        <td><input name = "userId" value = "${ userForm.userId }"/></td>
		    </tr>
		</table><br>
        <input type="submit" value = "検索">
    </form:form>
	</div>
</body>
</html>