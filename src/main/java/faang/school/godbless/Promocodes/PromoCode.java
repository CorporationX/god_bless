package faang.school.godbless.Promocodes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

//@EqualsAndHashCode(exclude = { "discount", "minimumOrderSum", "expirationDate", "isUsed" })
@AllArgsConstructor
@Getter
public class PromoCode {
    @EqualsAndHashCode.Include
    private String promoCode;
    private int discount;
    private int minimumOrderSum;
    private LocalDateTime expirationDate;
    private boolean isUsed;

    public synchronized boolean isValidForOrder(Order order) {
        return expirationDate.isAfter(LocalDateTime.now()) && order.getTotalPrice() >= minimumOrderSum && !isUsed;
    }

    public synchronized void setIsUsed() {
        isUsed = true;
    }
}
