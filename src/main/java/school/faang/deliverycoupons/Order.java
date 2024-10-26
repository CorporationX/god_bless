package school.faang.deliverycoupons;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Order {
    private final List<Product> products;
    private double totalDiscount = 0.0;

    public void applyDiscount(double discount) {
        totalDiscount += discount;
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
    
    public double getPriceAfterDiscount() {
        double totalPrice = getTotalPrice();
        return totalPrice - (totalPrice * totalDiscount / 100);
    }
}

