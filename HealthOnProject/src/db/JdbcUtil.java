package db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	public JdbcUtil(){
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection con=null;
		
		try {
			/*Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQLDB");
			con = ds.getConnection();*/
			con=DriverManager.getConnection("jdbc:mysql://localhost:3305/healthon?useSSL=false", "root", "dongyang");
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con){
		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Statement stmt){
		
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(ResultSet rs){
		
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void commit(Connection con){
		
		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void rollback(Connection con){
		
		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
