package faang.school.godbless.bjs2_6157;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Getter
@EqualsAndHashCode(of = "code")
public final class PromoCode implements Comparable<PromoCode> {
    private final String code;
    private final int discount;
    private final LocalDateTime expirationDate;
    private final double minimumOrderValue;
    private final AtomicBoolean isUsed = new AtomicBoolean(false);

    public PromoCode(String code, int discount, LocalDateTime expirationDate, double minimumOrderValue) {
        this.code = code;
        this.discount = discount;
        this.expirationDate = expirationDate;
        this.minimumOrderValue = minimumOrderValue;
    }

    public boolean isValidForOrder(Order order) {
        log.info("Check valid promo {} for order {}", code, order.getId());
        if (order.getTotalPrice() < minimumOrderValue) {
            log.error("Sum {} of order {} to small (smaller then < {} for discount {}", order.getTotalPrice(), order.getId(), minimumOrderValue, discount);
            return false;
        }
        if (isUsed.get()) {
            log.error("PromoCode {} is already used", code);
            return false;
        }
        if (expirationDate.isBefore(LocalDateTime.now())) {
            log.error("PromoCode date {} for {} already expired", expirationDate, code);
            return false;
        }
        return true;
    }

    public void setIsUsed() {
        log.info("PromoCode {} is used now", code);
        isUsed.set(true);
    }

    @Override
    public int compareTo(PromoCode promoCode) {
        return this.code.compareTo(promoCode.getCode());
    }
}
