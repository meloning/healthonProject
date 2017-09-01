<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
#img{
	border-color: #f4f4f4;
	border-width: thick;
}
#wrap-content{
padding:10px;
margin-left:300px;
	width:960px;
	margin:0 auto;
	background-color:#f4f4f4;
	text-align:left;
}
</style>
</head>
<body>
<header>
<jsp:include page="common/header.jsp" flush="false"/>
</header>
<div id="container-header">
<span class="titles">소개</span>
<p class="titles-content">여기를 클릭해 내용을 입력하세요. 마우스로 텍스트 상자의 위치와 크기를 변경하고, 텍스트 에디터에서 글꼴과 색상을 선택해 보세요. 다양한 한글 글꼴을 사용하려면, 글꼴 언어를 한국어로 지정하세요.</p>
</div>
<section id="wrap">
<img src="">
<img src="">
<img src="">
<div id="wrap-content">
<p>
여기를 클릭해 내용을 입력하세요. 마우스로 텍스트 상자의 위치와 크기를 변경하고, 텍스트 에디터에서 글꼴과 색상을 선택해 보세요. 다양한 한글 글꼴을 사용하려면, 글꼴 언어를 한국어로 지정하세요. 나만의 콘텐츠, 나만의 스타일을 위한 나만의 홈페이지를 완성해 보세요! 단순한 아이디어 구상부터 블로그 제작, 작품 시연, 쇼핑몰 운영, 기업 비즈니스 홍보까지 온라인 세상에 펼쳐진 가능성은 여전히 무궁무진합니다.
</p><br><p>
Wix는 사용자의 선호 및 필요에 따라 최고 수준의 홈페이지를 제작할수 있는 모든 솔루션을 갖추고 있습니다. 홈페이지 템플릿 컬렉션에서 마음에 드는 디자인을 선택한후, 원하는대로 편집해 나만의 홈페이지를 완성하세요. 여기를 클릭해 내용을 입력하세요. 마우스로 텍스트 상자의 위치와 크기를 변경하고, 텍스트 에디터에서 글꼴과 색상을 선택해 보세요. 다양한 한글 글꼴을 사용하려면, 글꼴 언어를 한국어로 지정하세요. 나만의 콘텐츠, 나만의 스타일을 위한 나만의 홈페이지를 완성해 보세요!
 </p><br><p>
단순한 아이디어 구상부터 블로그 제작, 작품 시연, 쇼핑몰 운영, 기업 비즈니스 홍보까지 온라인 세상에 펼쳐진 가능성은 여전히 무궁무진합니다. Wix는 사용자의 선호 및 필요에 따라 최고 수준의 홈페이지를 제작할수 있는 모든 솔루션을 갖추고 있습니다. 홈페이지 템플릿 컬렉션에서 마음에 드는 디자인을 선택한후, 원하는대로 편집해 나만의 홈페이지를 완성하세요.
</p>
</div>
</section>
<footer>
<jsp:include page="common/footer.jspf"/>
</footer>
</body>
</html>