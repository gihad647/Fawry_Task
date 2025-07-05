package ecommerce.Main;
import ecommerce.model.*;

import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Product cheese = new ExpiringItem("Cheese", 100.0, 20, LocalDate.now().plusDays(5), 0.2); // $100, 200g
        Product biscuits = new ExpiringItem("Biscuits", 150.0, 50, LocalDate.now().plusDays(5), 0.7); // $150, 700g

        // Create customer
        Customer customer = new Customer(1000.0);

        // Add products to cart
        customer.getCart().add(cheese, 2); // 2 Cheese
        customer.getCart().add(biscuits, 1); // 1 Biscuits

        // Perform checkout
        customer.checkout();
    }
}
