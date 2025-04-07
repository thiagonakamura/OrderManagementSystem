package model.entities;

/**
 * Represents a client with basic personal information.
 */
public class Client {

	// The name of the client
	private String name;
	
	// The address of the client
	private String address;
	
	public Client(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
