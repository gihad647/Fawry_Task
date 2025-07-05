package ecommerce.model;

import java.time.LocalDate;

public class ExpiringItem extends Product implements ShippableItem {
    private LocalDate expiryDate;
    private double weight;

    public ExpiringItem(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = 0;
    }

    public ExpiringItem(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean IsExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public boolean IsShippable() {
        return weight > 0 && !IsExpired();
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
