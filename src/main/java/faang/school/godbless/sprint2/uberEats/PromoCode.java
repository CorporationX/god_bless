package faang.school.godbless.sprint2.uberEats;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Evgenii Malkov
 */
@Slf4j
@RequiredArgsConstructor
@Getter
public class PromoCode {
    private final String code;
    private final int discount;
    private final long expirationDate;
    private final double minimumOrderValue;
    private volatile boolean isUsed;

    public boolean isValidForOrder(double orderValue) {
        if (minimumOrderValue > orderValue) {
            log.error("Сумма заказа {} меньше минимального размера {} для промокода {}", orderValue, minimumOrderValue, code);
            return false;
        }
        if (isUsed) {
            log.error("Промокод {} уже был использован", code);
            return false;
        }
        long currentDateTime = System.currentTimeMillis();
        if (currentDateTime > expirationDate) {
            log.error("Срок действия промокода истек {}. Сейчас {}", formattedDateTime(this.expirationDate), formattedDateTime(currentDateTime));
            return false;
        }
        return true;
    }

    public synchronized boolean setIsUsedPromocode() {
        if (this.isUsed) {
            log.error("Промокод {} уже использован", code);
            return false;
        }
        this.isUsed = true;
        return true;
    }

    private String formattedDateTime(long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(date);
    }
}
