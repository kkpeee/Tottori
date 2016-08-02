<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./resources/css/style.css" rel="stylesheet" type="text/css">
<title>ホーム</title>
</head>
<body>
<div style="text-align:center">
	<h1>管理者ホーム画面</h1>

			<p><c:forEach items = "${ messages }" var = "message">
				<font color = "red"><c:out value = "${ message }" /></font>
			</c:forEach></p>

	    	<table class="price">
			<tbody>
	        <tr>
		        <td class="c1"><a href="lendBook"><button >貸出</button></a></td>
		        <td class="c1"><a href="returnBook"><button >返却</button></a></td>
		        <td class="c1"><a href="reserveBook"><button >予約</button></a></td>
		    </tr>
		    <tr>
		        <td class="c1"><a href="userRegister"><button >ユーザー登録</button></a></td>
		        <td class="c1"><IMG src="http://group.baristride.co.jp/wp-content/uploads/site-logo.png"width="100" height="22"></td>
		        <td class="c1"><a href="userSearch"><button >ユーザー更新</button></a></td>
		    </tr>
		     <tr>
		     	<td class="c1"><a href="bookRegister"><button >図書登録</button></a></td>
		        <td class="c1"><a href="blackList"><button >延滞者</button></a></td>
		        <td class="c1"><a href="changeStatus"><button >本の状態変更</button></a></td>
		     </tr>
		     <tr>
		        <td class="c1"><a href="userManagement"><button >ユーザー確認</button></a></td>
		        <td class="c1"><a href="bookManagement"><button >本確認</button></a></td>
		        <td class="c1"><a href="manageLogin"><button >ログアウト</button></a></td>
		    </tr>
		    </tbody>
		</table>
</div>
</body>
</html>