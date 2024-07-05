package faang.school.godbless.delivery_coupons;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Getter
@ToString
@RequiredArgsConstructor
public class Order {
    private final List<Product> productList;

    public double applyDiscount(PromoCode promoCode) {
        promoCode.setUsed(true);
        return getTotalPrice() * (100 - promoCode.getDiscount()) / 100;
    }

    public double getTotalPrice() {
        if (productList == null) {
            log.warn("Someone trying to order nothing");
            throw new IllegalArgumentException("Product list cannot be null");
        }
        return productList.stream().map(Product::getPrice).reduce(0.0, Double::sum);
    }


    public boolean isValidPromoCode(PromoCode promoCode, double orderTotalPrice) {
        return orderTotalPrice >= promoCode.getMinimumOrderValue() &&
                promoCode.getExpirationDate().isAfter(LocalDateTime.now()) &&
                !promoCode.isUsed();
    }
}
