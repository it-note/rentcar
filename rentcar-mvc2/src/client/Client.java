package client;

import java.sql.Timestamp;

public class Client {
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

	public Client(int clientId, String id, String password, String name, String phone, String zonecode, String address, String subAddress, String type, Timestamp regDate) {
		super();
		this.clientId = clientId;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.zonecode = zonecode;
		this.address = address;
		this.subAddress = subAddress;
		this.type = type;
		this.regDate = regDate;
	}
	
	public Client(int clientId, String id, String name, String type) {
		super();
		this.clientId = clientId;
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public Client(ClientRequestDto clientDto) {
		this.id = clientDto.getId();
		this.password = clientDto.getPassword();
		this.name = clientDto.getName();
		this.phone = clientDto.getPhone();
		this.zonecode = clientDto.getZonecode();
		this.address = clientDto.getAddress();
		this.subAddress = clientDto.getSubAddress();
		this.type = clientDto.getType();
	}

	public int getClientId() {
		return clientId;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getZonecode() {
		return zonecode;
	}

	public String getAddress() {
		return address;
	}

	public String getSubAddress() {
		return subAddress;
	}

	public String getType() {
		return type;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

}
