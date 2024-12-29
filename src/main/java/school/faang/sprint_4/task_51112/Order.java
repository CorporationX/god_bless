package school.faang.sprint_4.task_51112;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Order {
    public static final int PERCENTAGE_INDEX = 100;
    private static final AtomicInteger counter = new AtomicInteger(1);
    private final int id;
    private final List<Product> products;

    public Order(List<Product> products) {
        this.id = counter.getAndIncrement();
        this.products = products;
    }

    public double applyDiscount(double discount) {
        ValidationUtils.isPositive(discount, "Скидка");
        double totalPrice = getTotalPrice();
        return totalPrice - (totalPrice / PERCENTAGE_INDEX * discount);
    }

    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::price)
                .sum();
    }
}
