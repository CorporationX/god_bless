package faang.school.godbless.Promocodes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

//@EqualsAndHashCode(exclude = { "discount", "minimumOrderSum", "expirationDate", "isUsed" })
@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class PromoCode {
    private String promoCode;
    @EqualsAndHashCode.Exclude
    private int discount;
    @EqualsAndHashCode.Exclude
    private int minimumOrderSum;
    @EqualsAndHashCode.Exclude
    private LocalDateTime expirationDate;
    @EqualsAndHashCode.Exclude
    private boolean isUsed;

    public synchronized boolean isValidForOrder(Order order) {
        return expirationDate.isAfter(LocalDateTime.now()) && order.getTotalPrice() >= minimumOrderSum && !isUsed;
    }

    public synchronized void setIsUsed() {
        isUsed = true;
    }
}
