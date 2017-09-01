package action.member;

import java.io.PrintWriter;
import action.Action;
import svc.member.MemberLoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;
import vo.MemberBean;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
public class MemberLoginAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		// 이전에 id라는 이름의 세션이 있으면 삭제.
		if (session.getAttribute("id") != null) {
			session.removeAttribute("id");
		}

		MemberBean member = new MemberBean();
		/*
		 * Cookie[] cookieArray = request.getCookies(); String id = ""; String
		 * passwd = "";
		 * 
		 * if(cookieArray != null){ for (int i = 0; i < cookieArray.length; i++)
		 * { if(cookieArray[i].getName().equals("loginCookie")){
		 * if(cookieArray[i].getName().equals("memberEmail")){ id =
		 * cookieArray[i].getValue(); } else
		 * if(cookieArray[i].getName().equals("memberPasswd")){ passwd =
		 * cookieArray[i].getValue(); } }else{
		 * 
		 * } } member.setMemberEmail(id); member.setMemberPasswd(passwd); }
		 */

		member.setMemberEmail(request.getParameter("memberEmail"));
		member.setMemberPasswd(request.getParameter("memberPasswd"));

		String useCookie = request.getParameter("useCookie");
		// System.out.println(useCookie);
		MemberLoginService memberLoginService = new MemberLoginService();
		boolean loginResult = memberLoginService.login(member);

		ActionForward forward = null;
		if (loginResult) {
			if (member.getMemberEmail().equals("admin")) { // 조만간 합칠 예정
				forward = new ActionForward();
				session.setAttribute("id", member);
				forward.setRedirect(true);
				forward.setPath("./memberListAction.mb");

			} else { // 조만간 합칠 예정
				forward = new ActionForward();
				session.setAttribute("id", member);
				session.setMaxInactiveInterval(30);
				forward.setRedirect(true);
				forward.setPath("./index.jsp");
				// 사용자가 자동로그인 체크했을경우 useCookie => on
				if (useCookie!=null) {
					Cookie Autologin = new Cookie("Autologin", Base64.encode((session.getId().toString().concat(request.getRemoteAddr()).getBytes())));
					System.out.println("cookie : "+Autologin.toString());
					int amount = 60;
					Autologin.setMaxAge(amount);
					Autologin.setPath("/");

					// 응답에 쿠키 추가
					response.addCookie(Autologin);
					/*
					 * // currentTimeMills()가 1/1000초 단위임으로 1000곱해서 더해야함
					 * Timestamp sessionLimit = new
					 * Timestamp(System.currentTimeMillis() + (1000*amount)); //
					 * 현재 세션 id와 유효시간을 사용자 테이블에 저장한다.
					 * memberLoginService.keepLogin(member.getMemberEmail(),
					 * session.getId(), sessionLimit); //업뎃이 안돼....ㅠ
					 */
					
					memberLoginService.keepLogin(member.getMemberEmail(), session.getId(), amount);
				}
			}
		} else {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패');");
			out.println("location.href='./loginForm.mb';");
			out.println("</script>");
		}
		return forward;
	}
}