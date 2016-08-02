<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>図書館システム</title>
	</head>
	<body>
	<div style="text-align:center">
		<h1>図書館システム</h1>
			<a href="${pageContext.request.contextPath}/login ">ログイン</a>
			<a href="${pageContext.request.contextPath}/reserveBook">検索</a>
	</div>
	</body>
</html>