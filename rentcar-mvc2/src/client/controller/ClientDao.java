package client.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.NamingException;

import client.Client;
import client.ClientRequestDto;
import util.DBManager;

public class ClientDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private ClientDao() {
	}

	private static ClientDao instance = new ClientDao();

	public static ClientDao getInstance() {
		return instance;
	}

	// Create
	public void createClient(ClientRequestDto clientDto) {
		Client client = new Client(clientDto);

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "INSERT INTO `client`(id, password, name, phone, zonecode, address, sub_address) VALUES(?, ?, ?, ?, ?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);

				this.pstmt.setString(1, client.getId());
				this.pstmt.setString(2, client.getPassword());
				this.pstmt.setString(3, client.getName());
				this.pstmt.setString(4, client.getPhone());
				this.pstmt.setString(5, client.getZonecode());
				this.pstmt.setString(6, client.getAddress());
				this.pstmt.setString(7, client.getSubAddress());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// Read
	public Client getClientById(String id) {
		Client client = null;

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM client WHERE id=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, id);

				this.rs = this.pstmt.executeQuery();
				if (this.rs.next()) {
					int clientId = this.rs.getInt(1);
					String password = this.rs.getString(3);
					String name = this.rs.getString(4);
					String phone = this.rs.getString(5);
					String zonecode = this.rs.getString(6);
					String address = this.rs.getString(7);
					String subAddress = this.rs.getString(8);
					String type = this.rs.getString(9);
//					Timestamp regDate = this.rs.getTimestamp(10);
					Timestamp regDate = this.rs.getTimestamp(10, Calendar.getInstance());

					client = new Client(clientId, id, password, name, phone, zonecode, address, subAddress, type,
							regDate);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return client;
	}

	public ArrayList<Client> getClientAll() {
		ArrayList<Client> list = new ArrayList<Client>();

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM client";

			try {
				this.pstmt = this.conn.prepareStatement(sql);

				this.rs = this.pstmt.executeQuery();
				while (this.rs.next()) {
					int clientId = this.rs.getInt(1);
					String id = this.rs.getString(2);
					String password = this.rs.getString(3);
					String name = this.rs.getString(4);
					String phone = this.rs.getString(5);
					String zonecode = this.rs.getString(6);
					String address = this.rs.getString(7);
					String subAddress = this.rs.getString(8);
					String type = this.rs.getString(9);
					Timestamp regDate = this.rs.getTimestamp(10);
					System.out.println("regDate : " + regDate);

					Client client = new Client(clientId, id, password, name, phone, zonecode, address, subAddress, type,
							regDate);
					list.add(client);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return list;
	}

	public Client getClientByPhone(String phone) {
		Client client = null;

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM client WHERE phone=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, phone);

				this.rs = this.pstmt.executeQuery();
				if (this.rs.next()) {
					int clientId = this.rs.getInt(1);
					String id = this.rs.getString(2);
					String password = this.rs.getString(3);
					String name = this.rs.getString(4);
					String zonecode = this.rs.getString(6);
					String address = this.rs.getString(7);
					String subAddress = this.rs.getString(8);
					String type = this.rs.getString(9);
					Timestamp regDate = this.rs.getTimestamp(10, Calendar.getInstance());

					client = new Client(clientId, id, password, name, phone, zonecode, address, subAddress, type,
							regDate);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}
		return client;
	}

	// Upate
	// Delete

}
