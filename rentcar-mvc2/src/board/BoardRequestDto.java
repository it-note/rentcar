package board;

import java.sql.Blob;
import java.sql.Timestamp;

public class BoardRequestDto {

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
	
	public BoardRequestDto(int clientId, String title, String contents, Blob image, String type, int vehicleId) {
		super();
		this.clientId = clientId;
		this.title = title;
		this.contents = contents;
		this.image = image;
		this.type = type;
		this.vehicleId = vehicleId;
	}

	public int getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	
}
