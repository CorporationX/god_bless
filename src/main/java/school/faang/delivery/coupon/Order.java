package school.faang.delivery.coupon;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Order {
    private final List<Product> products;
    private double discount = 0;

    public Order(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void applyDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalPrice() {
        double total = getTotalPrice();
        return total - (total * discount / 100);
    }
}
