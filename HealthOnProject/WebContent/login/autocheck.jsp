<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="svc.member.MemberLoginService,vo.MemberBean" %>
<%@page trimDirectiveWhitespaces="true"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64" %>
<%
	Object obj = session.getAttribute("id");				
	MemberLoginService memberLoginService = new MemberLoginService();
	boolean success=false;
	if(obj==null){			//자동로그인유지세션이 없는경우
		Cookie[] cookieArray = request.getCookies();
		String sessionId="";
		if(cookieArray!=null){
			for (int i = 0; i < cookieArray.length; i++) {
				if (cookieArray[i].getName().equals("Autologin")) {
					sessionId = cookieArray[i].getValue();
				}
			}
			MemberBean mb = memberLoginService.checkMemberWithSessionKey(sessionId);
			if(mb!=null){
				session.setAttribute("id",mb);
				session.setMaxInactiveInterval(30);
				success=true;
			}
		}else{
			success=false;
		}
	}else{
		success=true;
	}
	out.println(success);
%>