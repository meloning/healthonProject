package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.member.MemberAutoLoginAction;
import action.member.MemberDeleteAction;
import action.member.MemberJoinAction;
import action.member.MemberListAction;
import action.member.MemberLoginAction;
import action.member.MemberLogoutAction;
import action.member.MemberViewAction;
import vo.ActionForward;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.mb")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;
		if(command.equals("/loginForm.mb")){
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./login/loginForm.jsp");
		}else if(command.equals("/joinForm.mb")){
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./login/joinForm.jsp");
		}else if(command.equals("/memberLoginAction.mb")){
			action = new MemberLoginAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}/*else if(command.equals("/memberAutoLoginAction.mb")){
			action = new MemberAutoLoginAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}*/else if(command.equals("/memberJoinAction.mb")){
		
			action = new MemberJoinAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/memberLogoutAction.mb")){
			action = new MemberLogoutAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(command.equals("/memberListAction.mb")){
			action = new MemberListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/memberViewAction.mb")){
			action = new MemberViewAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/memberDeleteAction.mb")){
			action = new MemberDeleteAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
