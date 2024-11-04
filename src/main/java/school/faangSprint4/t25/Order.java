package school.faangSprint4.t25;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> products;

    public Order(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public void applyDiscount(double discount) {
        double multiplier = 1 - (discount / 100.0);
        products.forEach(product ->
                product = new Product(product.name(), product.price() * multiplier));
    }

    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::price)
                .sum();
    }
}