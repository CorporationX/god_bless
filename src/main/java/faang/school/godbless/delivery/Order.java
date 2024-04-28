package faang.school.godbless.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Order {

    private final List<Product> products = new ArrayList<>();

    public void applyDiscount(int discount) {
        products.forEach(product -> {
            double price = product.getPrice();
            product.setPrice(price - (price / 100) * discount);
        });
    }

    public double getTotalPrice() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
