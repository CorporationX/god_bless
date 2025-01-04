package school.faang.task_51123;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Order {
    private final UUID orderId = UUID.randomUUID();
    private final List<Product> products = new ArrayList<>();
    private double totalPrice = 0.0;

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public void deleteProduct(UUID productId) {
        products.removeIf(product ->
                product.getProductId().equals(productId));
    }

    public void applyDiscount(double discount) {
        totalPrice = totalPrice - (totalPrice * (discount / 100.0));
    }
}
