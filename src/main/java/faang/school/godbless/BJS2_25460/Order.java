package faang.school.godbless.BJS2_25460;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class Order {

    private final int id;
    private List<Product> products = new ArrayList<>();
    private double totalPrice;

    public void applyDiscount(PromoCode promoCode) {
        System.out.println("Used promo code: " + promoCode + " for order: " + getId());
        totalPrice = totalPrice * (1 - promoCode.getDiscount() / 100);
        promoCode.use();
    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }
}
