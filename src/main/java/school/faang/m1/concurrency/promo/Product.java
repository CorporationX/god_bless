package school.faang.m1.concurrency.promo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @param price деньги: scale=2
 */
public record Product(String name, BigDecimal price) {
    public Product(String name, BigDecimal price) {
        this.name = Objects.requireNonNull(name);
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return name + "($" + price + ")";
    }
}
