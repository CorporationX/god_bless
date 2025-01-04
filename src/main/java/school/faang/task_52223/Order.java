package school.faang.task_52223;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class Order {
    private static final double TOTAL_DISCOUNT = 100;
    private List<Product> products = new ArrayList<>();

    public void applyDiscount(double discount) {
        double totalPrice = getTotalPrice();
        calculateDiscountedPrice(products, discount);
        log.info("Скидка на каждый продукт применена, общая сумма: " + totalPrice);
    }

    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    private void calculateDiscountedPrice(List<Product> products, double discount) {
        double originalPrice = getTotalPrice();
        if (originalPrice < 0 || discount < 0 || discount > TOTAL_DISCOUNT) {
            log.error("Некорректные значения цены или скидки");
        } else {
            double percentDiscount = (discount / 100);
            products.forEach(s -> s.setPrice(s.getPrice() * percentDiscount));
        }
    }

}
