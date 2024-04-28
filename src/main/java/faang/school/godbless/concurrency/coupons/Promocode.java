package faang.school.godbless.concurrency.coupons;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public final class Promocode implements Comparable<Promocode> {
    String code;
    /**
     * Discount in percentage
     */
    int discount;
    LocalDate expirationDate;
    int minOrderValue;
    AtomicBoolean isUsed;

    public Promocode(String code, int discount, LocalDate expirationDate, int minOrderValue) {
        this.code = code;
        this.discount = discount;
        this.expirationDate = expirationDate;
        this.minOrderValue = minOrderValue;
        isUsed = new AtomicBoolean(false);
    }

    public boolean isValidForOrder(Order order) {
        if (order.getTotalPrice(false) < minOrderValue) {
            log.info("Not enough order (id = " + order.getId() + ") value. Cannot apply promocode.");
            return false;
        }

        if (expirationDate.isBefore(LocalDate.now())) {
            log.info("Promocode (code = " + code + ") expired already. Cannot apply promocode.");
            return false;
        }

        if (isUsed.get()) {
            log.info("Promocode (code = " + code + ") is used already. Cannot apply promocode.");
            return false;
        }

        return true;
    }

    public void usePromocode() {
        isUsed.set(true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promocode promocode = (Promocode) o;
        return discount == promocode.discount && minOrderValue == promocode.minOrderValue && code.equals(promocode.code) && expirationDate.equals(promocode.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, discount, expirationDate, minOrderValue);
    }

    @Override
    public String toString() {
        return "Promocode[" +
                "code='" + code + '\'' +
                ", discount=" + discount +
                ", expirationDate=" + expirationDate +
                ", minOrderValue=" + minOrderValue +
                ']';
    }

    @Override
    public int compareTo(Promocode o) {
        return this.discount - o.getDiscount();
    }
}
