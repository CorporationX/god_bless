package faang.school.godbless.DeliveryCoupons;

import lombok.Data;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicBoolean;

@Data
public class PromoCode implements Comparable<PromoCode> {
    private String code;
    private double discount;
    private LocalDate expirationDate;
    private double minimumOrderValue;
    private AtomicBoolean isUsed;

    public PromoCode(String code, double discount, double minimumOrderValue) {
        this.code = code;
        this.discount = discount;
        this.expirationDate = LocalDate.now().plusDays(3);
        this.minimumOrderValue = minimumOrderValue;
        this.isUsed = new AtomicBoolean(false);
    }

    public boolean isValidFor(Order order) {
        return order.getTotalPrice() >= minimumOrderValue
                && expirationDate.isAfter(LocalDate.now())
                && !isUsed.get();
    }

    public void usePromoCode() {
        isUsed.set(true);
    }

    @Override
    public int compareTo(PromoCode o) {
        return this.code.compareTo(o.code);
    }
}
