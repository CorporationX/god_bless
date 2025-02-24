package fooddelivery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Setter;

import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class Order {
    private final List<Product> products;
    @Setter
    private double discountedPrice = -1;

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void applyDiscount(double discountPercent) {
        double total = getTotalPrice();
        this.discountedPrice = total - (total * discountPercent / 100.0);
    }
}
