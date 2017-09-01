<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<style type="text/css">
	#content{
		display: table;
		margin-left: auto;
		margin-right: auto;
	}
	h1{
		text-align:center;
		text-size:20px;
	}
	
	#id,#pw,#sb,#name{
		width:300px;
		height:45px;
		margin:10px;
	}
	table{
		text-align:center;
	}
</style>
</head>
<body>
<header></header>
<section id="content">
	<h1>회원가입</h1>
	<form action="../memberJoinAction.mb" method="post">
	<table>
		<tr><td><input type="text" name="memberName" id="name" placeholder="name" required></td></tr>
		<tr><td><input type="text" name="memberEmail" id="id" placeholder="email" required></td></tr>
		<tr><td><input type="password" name="memberPasswd" id="pw" placeholder="password" required></td></tr>
		<tr>
			<td><input type="submit" id="sb" value="확인"></td>
		</tr>
		<tr>
			<td>회원인경우,<a href="./loginForm.jsp">로그인하세요!</a></td>
		</tr>
	</table>
	</form>
</section>
</body>
</html>