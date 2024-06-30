package faang.school.godbless.coupon;

import lombok.Getter;

import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
public class PromoCode {
    private String code;
    private double discount;
    private GregorianCalendar expirationDate;
    private int minimumOrderValue;
    private volatile AtomicBoolean notUsed = new AtomicBoolean(true);
}
