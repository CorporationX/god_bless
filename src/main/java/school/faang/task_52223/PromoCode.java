package school.faang.task_52223;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class PromoCode {

    private static final double MINIMUM_ORDER_VALUE = 150;

    private String code;
    private double discount;
    private LocalDate date;
    private PromoCodeStatus status;

    public boolean isValidForOrder(Order order) {
        return order.getTotalPrice() > MINIMUM_ORDER_VALUE
                && status == PromoCodeStatus.ACTIVE
                && LocalDate.now().isBefore(date);
    }

    public void markAsUsed() {
        status = PromoCodeStatus.INVALID;
        log.info("Текущей промокод <" + this.code + "> недействителен.");
    }

}
