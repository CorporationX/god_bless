package bjs2_63072;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public record Order(List<Product> products) {
    public void applyDiscount(double discount) {
        var totalPrice = getTotalPrice();
        totalPrice -= totalPrice * (discount / 100.0);

        log.info("Применена скидка {}%. Цена со скидкой {} у.е.", discount, totalPrice);
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::price).sum();
    }
}
