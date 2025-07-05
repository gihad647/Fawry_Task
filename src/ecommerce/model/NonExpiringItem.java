package ecommerce.model;

public class NonExpiringItem extends Product implements ShippableItem {
    private double weight;

    public NonExpiringItem(String name, double price, int quantity) {
        super(name, price, quantity);
        this.weight = 0;
    }

    public NonExpiringItem(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public boolean IsShippable() {
        return weight > 0;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }
}
