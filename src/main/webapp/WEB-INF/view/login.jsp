<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	<meta charset="utf-8">
	<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
	<title>ログイン</title>
</head>
<body>
<div style="text-align:center">
	<h1>ログイン画面</h1>
		<p><font color = "red"><c:out value = "${ message }" /></font></p>

   <form:form modelAttribute="loginForm">
        <p><font color = "red"><form:errors path="*"  /></font></p>
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
    		<tr>
		        <td bgcolor="#99CC00" >ログインID</td>
		        <td><form:input path="id" /></td>
		    </tr>
		</table><br>
		<input id="submit" type="submit" value="ログイン" />
    </form:form>
</div>
</body>
</html>