package board;

import java.sql.Blob;
import java.sql.Timestamp;

public class Board {
	
	private int boardCode;
	private int clientId;
	private String clientName;
	private String title;
	private String contents;
	private Blob image;
	private Timestamp regDate;
	private Timestamp modifiedDate;
	private String type;
	private int vehicleId;
	
	public Board(int boardCode, int clientId, String clientName, String title, String contents, Blob image,
			Timestamp regDate, Timestamp modifiedDate, String type, int vehicleId) {
		super();
		this.boardCode = boardCode;
		this.clientId = clientId;
		this.clientName = clientName;
		this.title = title;
		this.contents = contents;
		this.image = image;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
		this.type = type;
		this.vehicleId = vehicleId;
	}
	
	public Board(BoardRequestDto baordDto) {
		this.clientId = baordDto.getClientId();
		this.title = baordDto.getTitle();
		this.contents = baordDto.getContents();
		this.image = baordDto.getImage();
		this.type = baordDto.getType();
		this.vehicleId = baordDto.getVehicleId();
	}

	public int getBoardCode() {
		return boardCode;
	}

	public int getClientId() {
		return clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public Blob getImage() {
		return image;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public String getType() {
		return type;
	}

	public int getVehicleId() {
		return vehicleId;
	}
	
	

}
