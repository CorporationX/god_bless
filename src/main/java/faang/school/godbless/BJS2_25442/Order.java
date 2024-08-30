package faang.school.godbless.BJS2_25442;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    List<Product> products;

    public void applyDiscount(double discount) {
        products.forEach(product -> product.setPrice(product.getPrice() / 100 * (100 - discount)));
    }

    public double getTotalPrice() {
        return this.products.stream().mapToDouble(Product::getPrice).sum();
    }
}
