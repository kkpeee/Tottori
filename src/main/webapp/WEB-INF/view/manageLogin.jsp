<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
<title>管理者ログイン</title>
</head>
<body>
<div style="text-align:center">
	<h1>管理者ログイン画面</h1>
	<c:forEach items = "${ messages }" var = "message">
		<li><c:out value = "${ message }" /><br>
	</c:forEach>

   <form:form modelAttribute="manageForm">
       <p><font color = "red"><form:errors path="*"  /></font></p>
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
    		<tr>
		        <td bgcolor="#99CC00" >ログインID</td>
		        <td><input type="number" name="loginId" value="${loginManager.loginId}" id="loginId"/></td>
		    </tr>
		    <tr>
		        <td bgcolor="#99CC00" >パスワード</td>
		        <td><input name="password" type="password" id="password"/></td>
		    </tr>
		</table><br>
		<input id="submit" type="submit" value="ログイン" />
    </form:form>
</div>
</body>
</html>