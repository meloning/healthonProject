package action.member;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;
import vo.MemberBean;
import action.Action;
import svc.member.MemberJoinService;
public class MemberJoinAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	
		 	MemberBean member=new MemberBean();
	   		boolean joinResult=false;
	   		
	   		member.setMemberEmail(request.getParameter("memberEmail"));
	   		member.setMemberPasswd(request.getParameter("memberPasswd"));
	   		member.setMemberName(request.getParameter("memberName"));
	   		/*member.setMemberPhone(request.getParameter("memberPhone"));
	   		member.setMemberAddr1(request.getParameter("memberAddr1"));
	   		member.setMemberAddr2(request.getParameter("memberAddr2"));*/
	   		
	   		MemberJoinService memberJoinService = new MemberJoinService();
	   		joinResult=memberJoinService.joinMember(member);
	   		
	   		ActionForward forward = null;
	   		if(joinResult==false){
	   			response.setContentType("text/html;charset=UTF-8");
	   			PrintWriter out = response.getWriter();
	   			out.println("<script>");
	   			out.println("alert('회원등록실패')");
	   			out.println("history.back()");
	   			out.println("</script>");
		   	}
	   		else{
	   	    forward = new ActionForward();
	   		forward.setRedirect(true);
	   		forward.setPath("./loginForm.mb");
	   		}
	   		return forward;
	}
}