<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
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
	
	#id,#pw,#sb{
		width:300px;
		height:45px;
		margin:10px;
	}
	table{
		text-align:center;
	}
</style>
<!-- <script type="text/javascript">
function AutoLogin(){
	var cook=document.cookie;
	if(cook!=""){
		document.getElementById("id").value=getCookieEmail(cook);
		document.getElementById("pw").value=getCookiePass(cook);
		document.form.submit();
		return true;
	}else{
		return false;
	}
}
function getCookieEmail(cook){

	var idx = cook.indexOf("memberEmail", 0);
	var val = "";

	if(idx != -1) {
	cook = cook.substring(idx, cook.length);
	begin = cook.indexOf("=", 0) + 1;
	end = cook.indexOf(";", begin);
	val = unescape(cook.substring(begin, end));
	}
	return val;
}
function getCookiePass(cook){
	var idx = cook.indexOf("memberPasswd", 0);
	var val = "";

	if(idx != -1) {
	cook = cook.substring(idx, cook.length);
	begin = cook.indexOf("=", 0) + 1;
	end = cook.indexOf(";", begin);
	val = unescape(cook.substring(begin, end));
	}
	return val;
}
</script> -->
</head>
<body onload="AutoLogin()">
<header></header>
<section id="content">
	<h1>로그인</h1>
	<form action="../memberLoginAction.mb" id="login" method="post">
	<table>
		<tr><td><input type="text" name="memberEmail" id="id" placeholder="email" required></td></tr>
		<tr><td><input type="password" name="memberPasswd" id="pw" placeholder="password" required></td></tr>
		<tr>
			<td><input type="checkbox" name="useCookie" id="autoLogin">자동로그인
			<a href="#">비밀번호 찾기</a></td>
		</tr>
		<tr>
			<td><input type="submit" id="sb" value="확인"></td>
		</tr>
		<tr>
			<td><a href="./joinForm.jsp">가입하기</a></td>
		</tr>
	</table>
	</form>
</section>
</body>
</html>