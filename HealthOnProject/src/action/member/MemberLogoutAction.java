package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;
import action.Action;
public class MemberLogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		ActionForward forward = null;
		forward=new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./index.jsp");
		return forward;
	}

}
