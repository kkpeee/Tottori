<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
<title>予約</title>
</head>
<body>
<div style="text-align:center">
	<div style="text-align:right"><a href = "home">戻る</a></div>
	<h1>図書検索画面</h1>
	<h3>${errorMessage}</h3>
	<c:forEach items = "${ messages }" var = "message">
		<li><c:out value = "${ message }" />
	</c:forEach>

	<form:form modelAttribute="bookForm" method="GET" action="manageSearch" >
	    <div><font color = "red"><form:errors path="*"  /></font></div>
    	<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
	        <tr>
		        <td bgcolor="#99CC00" >書名</td>
		        <td><input name = "bookName"/></td>
		    </tr>
		    <tr>
		        <td bgcolor="#99CC00" >著者名</td>
		        <td><input name = "authorName"/></td>
		    </tr>
		    <tr>
		        <td bgcolor="#99CC00" >出版社名</td>
		        <td><input name = "publisher"/></td>
		    </tr>
		    <tr>
		        <td bgcolor="#99CC00" >ISBN</td>
		        <td><input type="number" name="isbn" /></td>
		    </tr>
		    <tr>
		        <td bgcolor="#99CC00" >書類種類</td>
		        <td>
					<select name = "documentName">
        				<option value= "null">(選択出来ます)</option>
						<c:forEach items = "${ Document }" var = "document">
							<option value = "${ document.documentName }" <c:if test = "${ document.documentId == book.documentId }">
							selected</c:if> >
							<c:out value = "${ document.documentName }" /></option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
		        <td bgcolor="#99CC00" >棚番号</td>
		        <td><input type="number" name="shelfId"/></td>
		    </tr>
		    </table><br>
        <input type="submit" value = "検索"/>
    </form:form>
</div>
</body>
</html>