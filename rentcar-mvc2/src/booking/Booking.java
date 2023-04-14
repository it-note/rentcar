package booking;

import java.sql.Timestamp;

public class Booking {
	private int vehicleId;
	private int clientId;
	private int venueId;
	private Timestamp date;
	private int hour;
	private Timestamp regDate;
	
	public Booking(int vehicleId, int clientId, int venueId, Timestamp date, int hour, Timestamp regDate) {
		super();
		this.vehicleId = vehicleId;
		this.clientId = clientId;
		this.venueId = venueId;
		this.date = date;
		this.hour = hour;
		this.regDate = regDate;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public int getClientId() {
		return clientId;
	}

	public int getVenueId() {
		return venueId;
	}

	public Timestamp getDate() {
		return date;
	}

	public int getHour() {
		return hour;
	}

	public Timestamp getRegDate() {
		return regDate;
	}
	
	
}

