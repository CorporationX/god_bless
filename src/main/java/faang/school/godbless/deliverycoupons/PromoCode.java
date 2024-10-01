package faang.school.godbless.deliverycoupons;

import lombok.Getter;

import java.time.LocalDate;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PromoCode {
    @Getter
    private final String code;
    @Getter
    private final double discount;
    private final LocalDate expirationDate;
    private final double minimumOrderValue;
    private boolean isUsed;
    private final Lock lock;

    public PromoCode(String code, double discount, LocalDate expirationDate, double minimumOrderValue) {
        this.code = code;
        this.discount = discount;
        this.expirationDate = expirationDate;
        this.minimumOrderValue = minimumOrderValue;
        this.isUsed = false;
        this.lock = new ReentrantLock();
    }

    public boolean isValidForOrder(Order order) {
        return !isUsed && !isExpired() && order.getSubtotal() >= minimumOrderValue;
    }

    private boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }

    public boolean use() {
        lock.lock();
        try {
            if (!isUsed) {
                isUsed = true;
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }
}