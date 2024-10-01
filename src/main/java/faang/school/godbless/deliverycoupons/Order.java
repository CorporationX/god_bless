package faang.school.godbless.deliverycoupons;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> products;
    private double discount;

    public Order() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void applyDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalPrice() {
        double total = products.stream()
                .mapToDouble(Product::price)
                .sum();
        return total - discount;
    }

    public double getSubtotal() {
        return products.stream()
                .mapToDouble(Product::price)
                .sum();
    }
}