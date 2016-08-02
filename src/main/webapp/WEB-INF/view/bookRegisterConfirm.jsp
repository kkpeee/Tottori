<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
<title>図書登録確認</title>
</head>
<body>

<div style="text-align:center">
	<div style="text-align:right"><a href = "bookRegister">戻る</a></div>
	<h1>図書登録確認画面</h1>
	<c:forEach items = "${ messages }" var = "message">
		<li><c:out value = "${ message }" /><br>
	</c:forEach>

    	<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333" align= "center">
	        <tr>
		        <td bgcolor="#99CC00" >書籍名</td>
		        <td><input value = "${ insertBook.bookName }" disabled="disabled"/></td>
		    </tr>
		    <tr>
		        <td bgcolor="#99CC00" >書籍名(ふりがな)</td>
		        <td><input value = "${ insertBook.bookKana }" disabled="disabled"/></td>
		    </tr>
		     <tr>
		        <td bgcolor="#99CC00" >著者名</td>
		        <td><input value = "${ insertBook.authorName }" disabled="disabled"/></td>
		    </tr>
		     <tr>
		        <td bgcolor="#99CC00" >著者名(ふりがな)</td>
		        <td><input value = "${ insertBook.authorName }" disabled="disabled"/></td>
		     </tr>
		     <tr>
		        <td bgcolor="#99CC00" >出版社名</td>
		        <td><input value = "${ insertBook.publisher }" disabled="disabled"/></td>
		     </tr>
		     <tr>
		        <td bgcolor="#99CC00" >ISBN</td>
		        <td><input value = "${ insertBook.isbn }" disabled="disabled"/></td>
		     </tr>
		      <tr>
		        <td bgcolor="#99CC00" >書類種類</td>
		        <td><input value = "${ insertBook.documentId }" disabled="disabled"/></td>
		     </tr>
		     <tr>
		        <td bgcolor="#99CC00" >棚番号</td>
		        <td><input value = "${ insertBook.shelfId }" disabled="disabled"/></td>
		     </tr>
		     <tr>
		        <td bgcolor="#99CC00" >図書館番号</td>
		        <td>
		        	<select disabled name = "libraryId">
						<c:forEach items = "${ Library }" var = "library">
							<option value = "${ library.libraryId }" <c:if test = "${ insertUser.libraryId == library.libraryId }">selected</c:if> >
							<c:out value = "${ library.libraryName }" /></option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table><br>
		<a href = "bookRegisterConfirm"><button >登録</button></a>
</div>
</body>
</html>