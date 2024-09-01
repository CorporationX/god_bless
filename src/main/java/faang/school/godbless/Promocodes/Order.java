package faang.school.godbless.Promocodes;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Order {
    private List<Product> products = new ArrayList<>();
    @Getter
    private double totalPrice = 0;

    public void applyDiscount(PromoCode promoCode) {
        totalPrice -= promoCode.getDiscount();
    }

    public synchronized void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

}
