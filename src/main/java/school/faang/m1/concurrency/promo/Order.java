package school.faang.m1.concurrency.promo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private final List<Product> products = new ArrayList<>();
    private final AtomicReference<BigDecimal> appliedDiscountPercent
            = new java.util.concurrent.atomic.AtomicReference<>(new BigDecimal("0.00"));

    public Order(Collection<Product> items) {
        this.products.addAll(items);
    }

    // to protect from several discounts, we try to apply max discount
    public void applyDiscount(BigDecimal discountPercent) {
        appliedDiscountPercent.getAndUpdate(old -> old.max(discountPercent)
                .setScale(2, RoundingMode.HALF_UP));
    }

    public BigDecimal getTotalPrice() {
        return products.stream()
                .map(Product::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPayableAmount() {
        BigDecimal total = getTotalPrice();
        BigDecimal fraction = appliedDiscountPercent.get()
                .divide(new BigDecimal("100.00"), 6, RoundingMode.HALF_UP);
        BigDecimal payable = total.multiply(BigDecimal.ONE.subtract(fraction));
        return payable.setScale(2, RoundingMode.HALF_UP);
    }

}
