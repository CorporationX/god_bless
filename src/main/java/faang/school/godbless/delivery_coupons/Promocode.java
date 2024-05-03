package faang.school.godbless.delivery_coupons;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Data
public class Promocode {
    private String code;
    private int discountPercentage;
    private LocalDateTime expirationDate;
    private double minimumOrderValue;
    private boolean isUsed;
    private ReentrantLock reentrantLock;

    public Promocode(String code, int discountPercentage, LocalDateTime expirationDate, double minimumOrderValue) {
        this.code = code;
        this.discountPercentage = discountPercentage;
        this.expirationDate = expirationDate;
        this.minimumOrderValue = minimumOrderValue;
        this.reentrantLock = new ReentrantLock();
    }

    public boolean isValidForOrder(double orderPrice) {
        if (minimumOrderValue > orderPrice) {
            log.error("Minimum order price should be greater then {}", minimumOrderValue);
            return false;
        }

        if (expirationDate.isBefore(LocalDateTime.now())) {
            log.error("Expired coupon");
            return false;
        }

        return true;
    }

    public void usePromocode() {
        isUsed = true;
    }
}
