package faang.school.godbless.coupon;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<Product, Integer> productByQuantity;

    public Order() {
        this.productByQuantity = new HashMap<>();
    }

    public void applyDiscount() {

    }

    public void addProduct(Product product) {
        productByQuantity.compute(product, (k, quantity) -> quantity == null ? 1 : quantity + 1);
    }

    public void removeProduct(Product product) {
        if (productByQuantity.containsKey(product)) {
            if (productByQuantity.get(product) > 1) {
                productByQuantity.compute(product, (k, quantity) -> quantity - 1);
            }
            productByQuantity.remove(product);
        }
    }

    public double getAllCost() {
        return productByQuantity.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice())
                .sum();
    }

    public Map<Product, Integer> getAllProductFromOrder() {
        return new HashMap<>(productByQuantity);
    }
}
