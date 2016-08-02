<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
<title>ユーザー更新確認</title>
</head>
<body>
	<div style="text-align:center">
	<div style="text-align:right"><a href = "userUpdate">戻る</a></div>
	<h1>ユーザー更新確認画面</h1>
	<c:forEach items = "${ messages }" var = "message">
		<li><c:out value = "${ message }" /><br>
	</c:forEach>

    	<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
	        <tr>
		        <td bgcolor="#99CC00" >ログインID</td>
		        <td><input value = "${ updateConfirmUser.userId }" disabled="disabled"/></td>
		    </tr>
		    <tr>
		        <td bgcolor="#99CC00" >名前</td>
		        <td><input value = "${ updateConfirmUser.userName }" disabled="disabled"/></td>
		    </tr>
		     <tr>
		        <td bgcolor="#99CC00" >住所</td>
		        <td><input value = "${ updateConfirmUser.address }" disabled="disabled"/></td>
		    </tr>
		     <tr>
		        <td bgcolor="#99CC00" >電話番号</td>
		        <td><input value = "${ updateConfirmUser.phoneNumber }" disabled="disabled"/></td>
		     </tr>
		     <tr>
		        <td bgcolor="#99CC00" >メールアドレス</td>
		        <td><input value = "${ updateConfirmUser.mail }" disabled="disabled"/></td>
		     </tr>
		     <tr>
		        <td bgcolor="#99CC00" >受取図書館</td>
		        <td>
		        	<select disabled name = "libraryId">
						<c:forEach items = "${ Library }" var = "library">
							<option value = "${ library.libraryId }" <c:if test = "${ updateConfirmUser.libraryId == library.libraryId }">selected</c:if>>
							<c:out value = "${ library.libraryName }" /></option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table><br>
		<a href = "userUpdateConfirm"><button >登録</button></a>
     </div>
</body>
</html>