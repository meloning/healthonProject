<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.MemberBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Junsu's HealthOn Site</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common/common.css">
<script type="text/javascript">
window.addEventListener("load", function() {
	HttpRequest_auto();
});
function HttpRequest_auto() {
	var xmlHttp = new XMLHttpRequest();

	xmlHttp.open("GET", "./login/autocheck.jsp?", true);//자동로그인 체크를 위한 jsp
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
			HttpResponse_junsu(xmlHttp.responseText);
	}
	xmlHttp.send();
}

function HttpResponse_junsu(res) {
	alert(res);
	
}
</script>
</head>
<body>
	<div class="loginf">
		<c:if test="${sessionScope.id==EMPTY }">
			<a href="./loginForm.mb">로그인</a>
		</c:if>
		<c:if test="${sessionScope.id!=EMPTY }">
		<c:set var="memberbean" value="${sessionScope.id }"></c:set>
			<a href="#"><c:out value="${memberbean }"/>님의 정보</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
				href="./memberLogoutAction.mb">로그아웃</a>
		</c:if>
	</div>
	<div class="title">
		<a href="<%=request.getContextPath()%>/index.jsp"> <img
			src="<%=request.getContextPath()%>/img/logo.png" class="logo">
			<h1 class="titleText">The Health On</h1>
		</a>
	</div>
	<nav>
		<ul class="menu">
			<a href="index.jsp"><li>홈</li></a>
			<a href="intro.jsp"><li>소개</li></a>
			<a href="index.html"><li>의료체험</li></a>
			<a href="index.html"><li>예약</li></a>
			<a href="index.html"><li>건강식품류</li></a>
			<a href="./board/listboard.jsp"><li>문의게시판</li></a>
		</ul>
	</nav>
</body>
</html>