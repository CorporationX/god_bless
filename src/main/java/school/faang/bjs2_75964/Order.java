package school.faang.bjs2_75964;

import lombok.Getter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class Order {
    @Getter
    private final long number;
    private final Set<Product> products;
    @Getter
    private final AtomicBoolean isDiscount = new AtomicBoolean(false);

    public Order(Set<Product> products) {
        this.number = OrderNumberCounter.getNextOrderNumber();
        this.products = products != null ? products : new HashSet<>();
    }

    public double applyDiscount(double discount) {
        isDiscount.set(true);

        double totalPrice = getTotalPrice();
        return totalPrice -  totalPrice * discount / 100;
    }

    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return number == order.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
