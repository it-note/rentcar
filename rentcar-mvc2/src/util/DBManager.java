package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		Context init;
		try {
			init = new InitialContext();
			DataSource datasource = (DataSource) init.lookup("java:comp/env/rentcar");
			conn = datasource.getConnection();
			System.out.println("DB연동 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연동 실패");
		}
		
		return conn;
	}

	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
