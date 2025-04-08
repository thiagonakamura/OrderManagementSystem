package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.Product;
import model.enums.OrderStatus;

/**
 * Entry point of the application responsible for handling user input,
 * creating an Order with its associated Client and Products,
 * and displaying order details.
 * 
 * This class simulates a basic order registration system using object-oriented principles.
 */
public class Program {

    public static void main(String[] args) {

    	// Set locale to US for consistent decimal formatting
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        
        // === Step 1: Order Initialization ===
        System.out.print("Order ID: ");
        Long id = sc.nextLong();
        sc.nextLine(); // Consume newline

        
        // === Step 2: Read and validate order status ===
        OrderStatus orderStatus = null;
        while (orderStatus == null) {
            try {
                System.out.print("Order status: ");
                String status = sc.nextLine().toUpperCase();
                orderStatus = OrderStatus.valueOf(status); // Converts input string to enum
            } 
            catch (IllegalArgumentException e) {
            	// Handle invalid enum input and prompt user again
                System.out.println("Invalid order status! Try again.");
            }
        }

        // === Step 3: Client data entry ===
        System.out.print("\nClient name: ");
        String client = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();

        // Create client and associate it with the order
        Client c = new Client(client, address);
        Order o = new Order(id, c, orderStatus);

        
        // === Step 4: Product(s) entry ===
        System.out.print("\nHow many products? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println();
            System.out.println(i + "° PRODUCT");
            sc.nextLine(); // Consume newline before reading product name
            System.out.print("Product name: ");
            String product = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            // Create new product and add to the order
            Product p = new Product(product, price);
            o.addProduct(p);
        }

        // === Step 5: Display final order summary ===
        o.displayDetails();
        
        sc.close();
    }
}

