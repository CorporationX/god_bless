package school.faang.bjs2_75964;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
public class PromoCode {
    private final String code;
    private final double discount;
    private final LocalDate expirationDate;
    private final double minimumOrderValue;
    private final AtomicBoolean isUsed = new AtomicBoolean(false);

    public PromoCode(String code, double discount, LocalDate expirationDate, double minimumOrderValue) {
        this.code = code;
        this.discount = discount;
        this.expirationDate = expirationDate;
        this.minimumOrderValue = minimumOrderValue;
    }

    public boolean isValidForOrder(Order order) {
        return order.getTotalPrice() > minimumOrderValue
                && expirationDate.isAfter(LocalDate.now())
                && !isUsed.get();
    }

    public void markAsUsed() {
        if (!isUsed.compareAndSet(false, true)) {
            throw new PromoCodeIsUsedException(code);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PromoCode promoCode = (PromoCode) o;
        return Objects.equals(code, promoCode.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
