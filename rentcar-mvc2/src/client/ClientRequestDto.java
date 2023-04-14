package client;

import java.sql.Timestamp;

public class ClientRequestDto {
	
	private int clientId;
	private String id;
	private String password;
	private String name;
	private String phone;
	private String zonecode;
	private String address;
	private String subAddress;
	private String type;
	private Timestamp regDate;
	
	public ClientRequestDto() {}
	
	public ClientRequestDto(String id, String password, String name, String phone, String zonecode, String address,
			String subAddress, String type) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.zonecode = zonecode;
		this.address = address;
		this.subAddress = subAddress;
		this.type = type;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZonecode() {
		return zonecode;
	}

	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubAddress() {
		return subAddress;
	}

	public void setsubAddress(String subAddress) {
		this.subAddress = subAddress;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	
	

}
