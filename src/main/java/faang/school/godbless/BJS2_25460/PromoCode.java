package faang.school.godbless.BJS2_25460;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class PromoCode implements Comparable<PromoCode> {
    private final Object lock = new Object();

    private String code;
    private double discount;
    private LocalDate expirationDate;
    private double minOrderValue;
    private boolean isUsed;

    public boolean isValidForOrder(Order order) {
        return order.getTotalPrice() > minOrderValue &&
                (expirationDate.isAfter(LocalDate.now()) || expirationDate.equals(LocalDate.now())) &&
                !isUsed;
    }

    public void use() {
        isUsed = true;
    }

    public static List<PromoCode> sortValidPromoCodesForOrder(Order order, List<PromoCode> promoCodes) {
        System.out.println("Find max valid promo codes for " + order.getId());
        return promoCodes.stream()
                .filter(promoCode -> promoCode.isValidForOrder(order))
                .sorted(PromoCode::compareTo)
                .toList();
    }

    @Override
    public int compareTo(PromoCode o) {
        return Double.compare(o.discount, discount);
    }
}
