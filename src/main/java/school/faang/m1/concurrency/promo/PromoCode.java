package school.faang.m1.concurrency.promo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
@Setter
public class PromoCode {
    private final String code;
    private final BigDecimal discount;
    private final LocalDate expirationDate;
    private final BigDecimal minimumOrderValue;
    private final AtomicBoolean used = new AtomicBoolean(false);

    public PromoCode(String code, BigDecimal discount, LocalDate expirationDate, BigDecimal minimumOrderValue) {
        this.code = Objects.requireNonNull(code);
        this.discount = discount;
        this.expirationDate = Objects.requireNonNull(expirationDate);
        this.minimumOrderValue = minimumOrderValue.setScale(2, RoundingMode.HALF_UP);
    }

    public boolean isValidForOrder(Order order) {
        if (isUsed()) {
            return false;
        }
        if (LocalDate.now().isAfter(expirationDate)) {
            return false;
        }
        return order.getTotalPrice().compareTo(minimumOrderValue) >= 0;
    }

    private boolean isUsed() {
        return used.get();
    }

    public boolean markAsUsed() {
        return used.compareAndSet(false, true);
    }


    @Override
    public String toString() {
        return "%s(%.1f%%, min=$%.2f, exp=%s, used=%s)".formatted(
                code, discount, minimumOrderValue, expirationDate, used.get());
    }
}
