package faang.school.godbless.BJS2_25460;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Getter
@ToString
@AllArgsConstructor
public class PromoCode implements Comparable<PromoCode> {
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
        if (!isUsed) {
            isUsed = true;
        }
    }

    public static Optional<PromoCode> findMaxValidPromoCodeForOrder(Order order, List<PromoCode> promoCodes) {
        System.out.println("Find max valid promo code for " + order.getId());
        return promoCodes.stream()
                .filter(promoCode -> promoCode.isValidForOrder(order))
                .max(PromoCode::compareTo);
    }

    @Override
    public int compareTo(PromoCode o) {
        return Double.compare(discount, o.discount);
    }
}
