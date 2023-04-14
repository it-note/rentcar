package key.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import key.Key;
import util.DBManager;

public class KeyDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private KeyDao() {
	}

	private static KeyDao instance = new KeyDao();

	public static KeyDao getInstance() {
		return instance;
	}

	public void createKey(Key key) {
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "INSERT INTO `key` VALUES(?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, key.getClientId());
				this.pstmt.setString(2, key.getClientKey());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	public String getKeyByClientId(int clientId) {
		String key = null;

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT client_key FROM `key` WHERE client_id=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, clientId);

				this.rs = this.pstmt.executeQuery();
				if (this.rs.next()) {
					key = this.rs.getString(1);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return key;
	}
}
