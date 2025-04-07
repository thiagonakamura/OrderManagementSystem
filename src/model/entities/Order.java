package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.enums.OrderStatus;

/**
 * Represents an order containing a list of products, 
 * the client who made the order, its ID and status.
 */
public class Order {

	// Unique identifier for the order
	private Long id;
	
	// Client who placed the order
	private Client client;
	
	// List of products included in the order
	private List<Product> list = new ArrayList<Product>();
	
	// Current status of the order
	private OrderStatus status;
	
	public Order(Long id, Client client, OrderStatus status) {
		super();
		this.id = id;
		this.client = client;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<Product> getList() {
		return list;
	}
	
	// Adds a product to the order.
	public void addProduct(Product p) {
		list.add(p);
	}
	
	
	// ARemoves a product to the order.
	public void removeProduct(Product p) {
		list.remove(p);
	}
	
	
	// Calculates the total price of all products in the order.
	public double getTotal() {
		double sum = 0;
		for (Product x : list) {
			sum += x.getPrice();
		}
		return sum;
	}
	
	
	// Displays the details of the order in the console.
	public void displayDetails() {
		System.out.println("------------------------");
		System.out.println("ORDER DETAILS");
		System.out.println("Order ID:" + id);
		System.out.println("Client: " + client.getName());
		System.out.println("Address: " + client.getAddress());
		System.out.println("Status: " + status);
		System.out.println("Products:");
		for(Product x : list) {
			System.out.println("- " + x.getName() + " | $" + String.format("%.2f", x.getPrice()));
		}
		System.out.println("Total: $" + String.format("%.2f", getTotal()));
	}
}
