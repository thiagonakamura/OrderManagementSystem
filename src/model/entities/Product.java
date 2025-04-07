package model.entities;

/**
 * Represents a generic product with a name and price.
 */
public class Product {

	// The name of the product
	private String name;
	
	// The price of the product
	private Double price;
	
	public Product(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
