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

		// ������ id��� �̸��� ������ ������ ����.
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
			if (member.getMemberEmail().equals("admin")) { // ������ ��ĥ ����
				forward = new ActionForward();
				session.setAttribute("id", member);
				forward.setRedirect(true);
				forward.setPath("./memberListAction.mb");

			} else { // ������ ��ĥ ����
				forward = new ActionForward();
				session.setAttribute("id", member);
				session.setMaxInactiveInterval(30);
				forward.setRedirect(true);
				forward.setPath("./index.jsp");
				// ����ڰ� �ڵ��α��� üũ������� useCookie => on
				if (useCookie!=null) {
					Cookie Autologin = new Cookie("Autologin", Base64.encode((session.getId().toString().concat(request.getRemoteAddr()).getBytes())));
					System.out.println("cookie : "+Autologin.toString());
					int amount = 60;
					Autologin.setMaxAge(amount);
					Autologin.setPath("/");

					// ���信 ��Ű �߰�
					response.addCookie(Autologin);
					/*
					 * // currentTimeMills()�� 1/1000�� ���������� 1000���ؼ� ���ؾ���
					 * Timestamp sessionLimit = new
					 * Timestamp(System.currentTimeMillis() + (1000*amount)); //
					 * ���� ���� id�� ��ȿ�ð��� ����� ���̺� �����Ѵ�.
					 * memberLoginService.keepLogin(member.getMemberEmail(),
					 * session.getId(), sessionLimit); //������ �ȵ�....��
					 */
					
					memberLoginService.keepLogin(member.getMemberEmail(), session.getId(), amount);
				}
			}
		} else {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�α��� ����');");
			out.println("location.href='./loginForm.mb';");
			out.println("</script>");
		}
		return forward;
	}
}