package board.controller;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import board.Board;
import util.DBManager;

public class BoardDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BoardDao () {}
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	
	public Board getBoardByCode(int code) {
		Board board = null;
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			try {
				String sql = "SELECT * FROM board WHERE board_code=?";
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, code);
				
				this.rs = this.pstmt.executeQuery();
				if(this.rs.next()) {
					int clientId = this.rs.getInt(2);
					String clientName = this.rs.getString(3);
					String title = this.rs.getString(4);
					String contents = this.rs.getString(5);
					Blob image = this.rs.getBlob(6);
					Timestamp regDate = this.rs.getTimestamp(7, Calendar.getInstance());
					Timestamp modifiedDate = this.rs.getTimestamp(8, Calendar.getInstance());
					String type = this.rs.getString(9);
					int vehicleId = this.rs.getInt(10);
					
					board = new Board(code, clientId, clientName, title, contents, image, regDate, modifiedDate, type, vehicleId);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return board;
	}
	
	public ArrayList<Board> getBoardByClientIdAll(int clientId) {
		ArrayList<Board> list = new ArrayList<Board>();
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			try {
				String sql = "SELECT * FROM board WHERE client_id=?";
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, clientId);
				
				this.rs = this.pstmt.executeQuery();
				while(this.rs.next()) {
					int boardCode = this.rs.getInt(1);
					String clientName = this.rs.getString(3);
					String title = this.rs.getString(4);
					String contents = this.rs.getString(5);
					Blob image = this.rs.getBlob(6);
					Timestamp regDate = this.rs.getTimestamp(7, Calendar.getInstance());
					Timestamp modifiedDate = this.rs.getTimestamp(8, Calendar.getInstance());
					String type = this.rs.getString(9);
					int vehicleId = this.rs.getInt(10);
					
					Board board = new Board(boardCode, clientId, clientName, title, contents, image, regDate, modifiedDate, type, vehicleId);
					list.add(board);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}
	
	public ArrayList<Board> getBoardAll() {
		ArrayList<Board> list = new ArrayList<Board>();
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "SELECT * FROM board WHERE type=1 ORDER BY reg_date DESC";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int boardCode = this.rs.getInt(1);
					int clientId = this.rs.getInt(2);
					String clientName = this.rs.getString(3);
					String title = this.rs.getString(4);
					String contents = this.rs.getString(5);
					Blob image = this.rs.getBlob(6);
					Timestamp regDate = this.rs.getTimestamp(7, Calendar.getInstance());
					Timestamp modifiedDate = this.rs.getTimestamp(8, Calendar.getInstance());
					String type = this.rs.getString(9);
					int vehicleId = this.rs.getInt(10);
					
					Board board = new Board(boardCode, clientId, clientName, title, contents, image, regDate, modifiedDate, type, vehicleId);
					list.add(board);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}
}
