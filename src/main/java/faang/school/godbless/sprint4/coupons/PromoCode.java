package faang.school.godbless.sprint4.coupons;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class PromoCode {
    private String code;
    private double discount;
    private LocalDate expirationDate;
    private int minimumOrderValue;
    private volatile boolean isUsed;

    public boolean isValidForOrder(Order order) {
        if(order.getTotalPrice() >= minimumOrderValue && !isUsed && expirationDate.isBefore(LocalDate.now())) {
            return true;
        }else {
            return false;
        }
    }
        public synchronized void usePromoCode(Order order) {
        if (!isUsed) {
            isUsed = true;
            // код для использования промокода
            order.setTotalPrice((int) (order.getTotalPrice() - discount));

        }
    }
    public void markAsUsed() {
        isUsed = true;
    }
}
