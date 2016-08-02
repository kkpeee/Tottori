<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
<title>ステータス変更</title>
</head>
<body>
<div style="text-align:center">
	<div style="text-align:right"><a href = "home">戻る</a></div>
	<h1>ステータス変更画面</h1>
	<c:forEach items = "${ messages }" var = "message">
		<li><c:out value = "${ message }" /><br>
	</c:forEach><br>

	<form:form modelAttribute="bookStatusForm">
        <p><font color = "red"><form:errors path="*"  /></font></p>
    	<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
		     <tr>
		        <td bgcolor="#99CC00" >状態</td>
		        <td>
					<select name = "statusId">
						<c:forEach items = "${ Status }" var = "status">
							<option value = "${ status.statusId }" >
							<c:out value = "${ status.statusName }" /></option>
						</c:forEach>
					</select>
				</td>
			</tr>
		    <tr>
		        <td bgcolor="#99CC00" >ISBN</td>
		        <td><input type="number" name = "isbn"/></td>
		    </tr>
		     <tr>
		        <td bgcolor="#99CC00" >図書館番号</td>
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
        <input type="submit" value = "変更"/>
    </form:form>
</div>
</body>
</html>