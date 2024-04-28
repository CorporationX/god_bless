package faang.school.godbless.bjs2_6157;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@AllArgsConstructor
public class Order {

    private int id;

    private final List<Product> products = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public double getTotalPrice() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);
    }

    public void applyDiscount(int discount) {
        products.forEach(product -> {
            double price = product.getPrice();
            product.setPrice(price - (price / 100 * discount));
        });
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
