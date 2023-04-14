package booking.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import booking.Booking;
import util.DBManager;

public class BookingDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private BookingDao() {}
	private static BookingDao instance = new BookingDao();
	public static BookingDao getInstance() {
		return instance;
	}
	
	public ArrayList<Booking> getBookingByClientIdAll(int clientId) {
		ArrayList<Booking> list = new ArrayList<Booking>();
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "SELECT * FROM booking WHERE client_id=? AND date < current_date() ORDER BY date";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, clientId);
				
				this.rs = this.pstmt.executeQuery();
				while(this.rs.next()) {
					int vehicleId = this.rs.getInt(1);
					int venueId = this.rs.getInt(3);
					Timestamp date = this.rs.getTimestamp(4);
					int hour = this.rs.getInt(5);
					Timestamp regDate = this.rs.getTimestamp(6);
					
					Booking book = new Booking(vehicleId, clientId, venueId, date, hour, regDate);
					list.add(book);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
