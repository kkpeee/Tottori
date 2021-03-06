<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
<title>ユーザー登録</title>
</head>
<body>
	<div style="text-align:center">
	<div style="text-align:right"><a href = "home">戻る</a></div>
	<h1>ユーザー登録画面</h1>
	<c:forEach items = "${ messages }" var = "message">
		<li><c:out value = "${ message }" /><br>
	</c:forEach>

	<p>
        <c:out value="${message}"></c:out>
    </p>

	<form:form modelAttribute="userForm">
		<div><font color="red"><form:errors path="*"  /></font></div>
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
	        <tr>
		        <td bgcolor="#99CC00" >ログインID</td>
		        <td><input name = "userId" type="text" value = "${ insertUser.userId }"/></td>
		    </tr>
		    <tr>
		        <td bgcolor="#99CC00" >名前</td>
		        <td><input name = "userName" value = "${ insertUser.userName }"/></td>
		    </tr>
		     <tr>
		        <td bgcolor="#99CC00" >住所</td>
		        <td><input name = "address" value = "${ insertUser.address }"/></td>
		    </tr>
		     <tr>
		        <td bgcolor="#99CC00" >電話番号</td>
		        <td><input name = "phoneNumber" type="tel" value = "${ insertUser.phoneNumber }"/></td>
		     </tr>
		     <tr>
		        <td bgcolor="#99CC00" >メールアドレス</td>
		        <td><input name = "mail" type="email" value = "${ insertUser.mail }"/></td>
		     </tr>
		     <tr>
		        <td bgcolor="#99CC00" >受取図書館</td>
		        <td>
		        	<select name = "libraryId">
						<c:forEach items = "${ Library }" var = "library">
							<option value = "${ library.libraryId }" <c:if test = "${ insertUser.libraryId == library.libraryId }">selected</c:if> >
							<c:out value = "${ library.libraryName }" /></option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table><br>
        <input type="submit" value = "登録">
     </form:form>
     </div>
</body>
</html>