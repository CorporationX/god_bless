package derschrank.sprint04.task25.bjstwo_51104.units;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class Order {
    private final String number;
    private final List<Product> products;
    private int discount;

    private boolean isProcessed;
    private Optional<PromoCode> promoCodeOpt;

    public Order(String num, List<Product> products) {
        number = num;
        this.products = products;
        discount = 0;
        promoCodeOpt = Optional.empty();
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::price).sum();
    }

    public double getTotalPriceWithDiscount() {
        return getTotalPrice() * (100 - discount) / 100;
    }

    public void applyDiscount(PromoCode promoCode) {
        promoCodeOpt = Optional.of(promoCode);
        int disc = promoCode.getDiscount();
        if (disc > 0 && disc <= 100) {
            this.discount = disc;
        }
    }

    public void processing() {
        isProcessed = true;
    }

    public boolean hasDiscount() {
        return discount > 0;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    @Override
    public String toString() {
        return String.format("%s, %.2f$ : %s", number, getTotalPrice(), products);
    }
}
