<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common/main.css">
<style>
.titles{
	font-family: "Nanum Gothic", "나눔고딕", "NanumGothic", sans-serif;
	color: #98c748;
	font-size: 20px;
	margin-left:300px;
	margin-right:100px;
}
.titles-content{
margin-left:400px;
	width:850px;
	height:50px;
}
#container-header{
	padding-top:20px;
	width:inherit;
	height:100px;
	margin:0 auto;
	background-color:#f4f4f4;
	text-align:left;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
<jsp:include page="../common/header.jsp" flush="false"/>
</header>
<div id="container-header">
<span class="titles">소개</span>
<p class="titles-content">여기를 클릭해 내용을 입력하세요. 마우스로 텍스트 상자의 위치와 크기를 변경하고, 텍스트 에디터에서 글꼴과 색상을 선택해 보세요. 다양한 한글 글꼴을 사용하려면, 글꼴 언어를 한국어로 지정하세요.</p>
</div>
</body>
</html>