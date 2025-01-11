package derschrank.sprint04.task25.bjstwo_51104.units;

import lombok.Getter;

import java.util.List;

@Getter
public class Order {
    private final String number;
    private final List<Product> products;
    private int discount;

    public Order(String num, List<Product> products) {
        number = num;
        this.products = products;
        discount = 0;
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::price).sum();
    }

    public double getTotalPriceWithDiscount() {
        return getTotalPrice() * (100 - discount) / 100;
    }

    public void applyDiscount(int discount) {
        if (discount > 0 && discount <= 100) {
            this.discount = discount;
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %.2f$ : %s", number, getTotalPrice(), products);
    }
}
