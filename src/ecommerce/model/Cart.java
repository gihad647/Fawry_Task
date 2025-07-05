package ecommerce.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("Error: Not enough quantity available for " + product.getName());
            return;
        }
        items.put(product, items.getOrDefault(product, 0) + quantity);
        product.setQuantity(product.getQuantity() - quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
