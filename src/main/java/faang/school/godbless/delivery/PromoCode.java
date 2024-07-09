package faang.school.godbless.delivery;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
@EqualsAndHashCode(of = "code")
public class PromoCode implements Comparable<PromoCode> {
    private final String code;
    private final int discount;
    private final LocalDateTime expirationDate;
    private final double minimumOrderValue;
    private final AtomicBoolean isUsed = new AtomicBoolean(false);

    public boolean isValidForOrder(Order order){
        if(order.getTotalPrice() < minimumOrderValue || isUsed.get() || expirationDate.isBefore(LocalDateTime.now())){
            return false;
        }
        return true;
    }

    public void setIsUsed(){
        this.isUsed.set(true);
    }

    public PromoCode(String code, int discount, LocalDateTime expirationDate, double minimumOrderValue) {
        this.code = code;
        this.discount = discount;
        this.expirationDate = expirationDate;
        this.minimumOrderValue = minimumOrderValue;
    }

    @Override
    public int compareTo(PromoCode promoCode) {
        return this.code.compareTo(promoCode.getCode());
    }
}
