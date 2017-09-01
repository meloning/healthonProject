package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

import vo.MemberBean;

public class MemberDAO {
	public static MemberDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	private MemberDAO() {

	}

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public String selectLoginId(MemberBean member) {
		String loginId = null;
		String sql = "SELECT memberEmail FROM member WHERE memberEmail=? AND memberPasswd=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPasswd());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				loginId = rs.getString("memberEmail");
			}
		} catch (Exception ex) {
			System.out.println(" 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return loginId;
	}

	public int insertMember(MemberBean member) {
		String sql = "INSERT INTO member(memberName,memberEmail,memberPasswd) VALUES (?,?,?)";
		int insertCount = 0;

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberPasswd());
			insertCount = pstmt.executeUpdate();
			commit(con);
		} catch (Exception ex) {
			rollback(con);
			System.out.println("joinMember 에러: " + ex);
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public ArrayList<MemberBean> selectMemberList() {
		String sql = "SELECT * FROM member";
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
		MemberBean mb = null;
		try {

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					mb = new MemberBean();
					mb.setMemberEmail(rs.getString("memberEmail"));
					mb.setMemberPasswd(rs.getString("memberPasswd"));
					mb.setMemberName(rs.getString("memberName"));
					mb.setMemberPhone(rs.getString("memberPhone"));
					mb.setMemberAddr1(rs.getString("memberAddr1"));
					mb.setMemberAddr2(rs.getString("memberAddr2"));
					memberList.add(mb);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDetailMember 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}

	public MemberBean selectMember(String id) {
		String sql = "SELECT * FROM member WHERE memberEmail=?";
		MemberBean mb = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mb = new MemberBean();
				mb.setMemberEmail(rs.getString("memberEmail"));
				mb.setMemberPasswd(rs.getString("memberPasswd"));
				mb.setMemberName(rs.getString("memberName"));
				mb.setMemberPhone(rs.getString("memberPhone"));
				mb.setMemberAddr1(rs.getString("memberAddr1"));
				mb.setMemberAddr2(rs.getString("memberAddr2"));
			}
		} catch (Exception ex) {
			System.out.println("getDetailMember 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return mb;
	}

	public int deleteMember(String id) {
		String sql = "DELETE FROM member WHERE memberEmail=?";
		int deleteCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
			commit(con);
		} catch (Exception ex) {
			rollback(con);
			System.out.println("deleteMember 에러: " + ex);
		} finally {
			close(pstmt);
		}

		return deleteCount;
	}

	public void keepLogin(String memberId, String sessionId, int amount) {
		/*
		 * Map<String,Object> map = new HashMap<String,Object>();
		 * map.put("memberId", memberId); map.put("sessionId", sessionId);
		 * map.put("next", next);
		 */
		Date date = new Date(System.currentTimeMillis());
		Time time = new Time(System.currentTimeMillis()+(1000*amount));
		String sql = "UPDATE member SET sessionKey=?, sessionLimit=? where memberEmail=?;";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sessionId);
			pstmt.setString(2, date.toString()+" "+time.toString());
			pstmt.setString(3, memberId);
			pstmt.executeUpdate();
			commit(con);
		} catch (Exception e) {
			rollback(con);
			System.out.println("updateSession 에러: " + e);
		} finally {
			close(pstmt);
		}
	}

	public MemberBean checkMemberWithSessionKey(String sessionId) {
		String sql = "SELECT * FROM member WHERE sessionKey=? and sessionLimit>now();";
		MemberBean mb = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sessionId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mb = new MemberBean();
				mb.setMemberEmail(rs.getString("memberEmail"));
				mb.setMemberPasswd(rs.getString("memberPasswd"));
				mb.setMemberName(rs.getString("memberName"));
				mb.setMemberPhone(rs.getString("memberPhone"));
				mb.setMemberAddr1(rs.getString("memberAddr1"));
				mb.setMemberAddr2(rs.getString("memberAddr2"));
			}
		} catch (Exception ex) {
			System.out.println("getDetailMember 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("SessionCheck: "+mb);
		return mb;
	}
}