package faang.school.godbless.coupon;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    private String name;
    private double price;

    public Product setDiscountForPrice(double discount) {
        return new Product(name, price - price * discount);
    }
}
