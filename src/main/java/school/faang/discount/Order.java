package school.faang.discount;

import java.util.List;

public class Order {
    private List<Product> products;
    private Product product;

    public Order(List<Product> products) {
        this.products = products;
    }

    public synchronized void applyDiscount(double discount) {
        for (Product p : products) {
            double newPrice = p.getPrice() * (1 - discount / 100.0);
            p.setPrice(Math.round(newPrice * 100.0) / 100.0);
        }
    }

    public double getTotalPrice() {
        return Math.round(
                products.stream()
                        .mapToDouble(Product::getPrice)
                        .sum() * 100.0
        ) / 100.0;
    }
}
