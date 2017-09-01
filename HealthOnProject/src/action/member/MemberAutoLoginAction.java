package action.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import action.Action;
import svc.member.MemberLoginService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberAutoLoginAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ActionForward forward = null;
		MemberLoginService memberLoginService = new MemberLoginService();
		Object obj = session.getAttribute("id");
		if(obj==null){
			Cookie[] cookieArray = request.getCookies();
			String sessionId="";
			if(cookieArray!=null){
				for (int i = 0; i < cookieArray.length; i++) {
					if (cookieArray[i].getName().equals("id")) {
						sessionId = cookieArray[i].getValue();
					}
				}
				MemberBean mb = memberLoginService.checkMemberWithSessionKey(sessionId);
				if(mb!=null){
					session.setAttribute("id",Base64.encode((mb.toString().concat(request.getRemoteAddr()).getBytes())));
					forward=null;
				}
			}
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./loginForm.mb");
		}
		forward=null;
		return forward;
	}

}
