package ecommerce.model;

import java.util.Map;

public class Customer {
    private Cart cart;
    private double balance;

    public Customer(double initialBalance) {
        this.cart = new Cart();
        this.balance = initialBalance;
    }

    public Cart getCart() {
        return cart;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        double subtotal = 0.0;
        double shippingFees = 0.0;
        double totalWeight = 0.0;
        Map<Product, Integer> items = cart.getItems();

        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            if (product instanceof ExpiringItem) {
                ExpiringItem exp = (ExpiringItem) product;
                if (exp.IsExpired()) {
                    System.out.println("Error: Product " + product.getName() + " is expired.");
                    return;
                }
            }
        }

        System.out.println("** Shipment notice **");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (product.IsShippable() && product instanceof ShippableItem) {
                ShippableItem shippable = (ShippableItem) product;
                double itemWeight = shippable.getWeight() * quantity * 1000;
                System.out.println(quantity + "x " + product.getName() + " " + (int) itemWeight + "g");
                totalWeight += shippable.getWeight() * quantity;
            }
        }
        System.out.println("Total package weight " + String.format("%.1f", totalWeight) + "kg");
        System.out.println();
        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double itemTotal = product.getPrice() * quantity;
            subtotal += itemTotal;
            System.out.println(quantity + "x " + product.getName() + " " + (int) itemTotal);
            if (product.IsShippable()) {
                shippingFees += 15.0 * quantity;
            }
        }

        double total = subtotal + shippingFees;

        if (total > balance) {
            System.out.println("Error: Insufficient balance. Required: $" + (int) total + ", Available: $" + (int) balance);
            return;
        }

        System.out.println("----------------------");
        System.out.println("Subtotal " + (int) subtotal);
        System.out.println("Shipping " + (int) shippingFees);
        System.out.println("Amount " + (int) total);

        balance -= total;
        cart.clear();
    }
}
