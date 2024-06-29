package faang.school.godbless.delivery_coupons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Getter
@ToString
@AllArgsConstructor
public class PromoCode {
    private String code;
    private double discount;
    private LocalDateTime expirationDate;
    private double minimumOrderValue;
    @Setter
    private boolean isUsed;
    private final Lock promoCodeLock = new ReentrantLock();
}
