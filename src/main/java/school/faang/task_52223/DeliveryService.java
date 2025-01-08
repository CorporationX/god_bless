package school.faang.task_52223;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Slf4j
@Getter
public class DeliveryService {

    private Map<String, PromoCode> promoCodes = new ConcurrentHashMap<>();
    private List<Order> processedOrders = new ArrayList<>();

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.put(promoCode.getCode(), promoCode);
    }

    public synchronized void processOrder(Order order, List<PromoCode> promoCodes) {

        List<PromoCode> validPromoCode = checkPromoCodeExists(order, promoCodes);

        PromoCode promoCodeWithMaxDiscount = getMaxDiscount(validPromoCode);

        if (promoCodeWithMaxDiscount != null) {
            order.applyDiscount(promoCodeWithMaxDiscount.getDiscount());
            log.info("Максимальная скидка применена!");
            promoCodeWithMaxDiscount.markAsUsed();
            deletePromoCode(promoCodeWithMaxDiscount);
        } else {
            order.applyDiscount(0);
            log.info("Нет действующих промокодов, скидка не применима");
        }

        processedOrders.add(order);

    }

    private List<PromoCode> checkPromoCodeExists(Order order, List<PromoCode> promoCods) {
        List<PromoCode> validPromoCode = promoCods.stream()
                .filter(s -> s.isValidForOrder(order) && promoCodes.containsKey(s.getCode()))
                .collect(Collectors.toList());

        log.info(validPromoCode.isEmpty() ? "Валидация промокода не пройдена!" :
                "Валидация промокодов к заказу пройдена!\nПроверяем максимальную скидку.\n");

        return validPromoCode;
    }


    private PromoCode getMaxDiscount(List<PromoCode> promoCods) {
        return promoCods.stream()
                .max(Comparator.comparingDouble(PromoCode::getDiscount))
                .orElse(null);
    }

    private void deletePromoCode(PromoCode promoCode) {
        promoCodes.remove(promoCode.getCode());
        log.info(String.format("Промокод <%s> удален!", promoCode.getCode()));
    }

}
