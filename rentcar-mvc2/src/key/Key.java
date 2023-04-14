package key;

public class Key {
	private int clientId;
	private String clientKey;

	public Key(int clientId, String clientKey) {
		this.clientId = clientId;
		this.clientKey = clientKey;
	}

	public int getClientId() {
		return clientId;
	}

	public String getClientKey() {
		return clientKey;
	}
	
	
}
