package svc.member;

import vo.MemberBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;

import dao.MemberDAO;

public class MemberLoginService {

	public boolean login(MemberBean member) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		boolean loginResult = false;
		String loginId = memberDAO.selectLoginId(member);
		if (loginId != null) {
			loginResult = true;
		}
		close(con);
		return loginResult;
	}

	public void keepLogin(String memberId, String sessionId, int amount) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		memberDAO.keepLogin(memberId, sessionId, amount);
	}

	public MemberBean checkMemberWithSessionKey(String sessionId) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		MemberBean mb = memberDAO.checkMemberWithSessionKey(sessionId);
		return mb;
	}

}
