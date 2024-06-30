package faang.school.godbless.sprint2.uberEats;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class DeliveryService {
    @Getter
    private final Queue<Order> orders = new ConcurrentLinkedDeque<>();
    private final Map<String, PromoCode> activePromocodes = new ConcurrentHashMap<>();

    public DeliveryService(Map<String, PromoCode> activePromocodes) {
        this.activePromocodes.putAll(activePromocodes);
    }

    public void processOrder(@NonNull Order order, List<String> promoCodes) {
        log.info("START!!! Оформляем заказ: {}, на начальную сумму: {}. Коды {}", order.getId(), order.getTotalPrice(), promoCodes);
        boolean withDiscount = applyDiscount(order, promoCodes);
        double totalPrice = order.getTotalPrice();
        if (withDiscount) {
            log.info("FINISH. Применилась скидка {}% промокод: {} в заказе {}. Result: {}", order.getDiscount(), order.getCode(), order.getId(), totalPrice);
        } else {
            log.info("FINISH. Стоимость товаров без скидки в заказе {}: {}", order.getId(), totalPrice);
        }
        orders.add(order);
    }

    private boolean applyDiscount(Order order, List<String> promoCodes) {
        Optional<PromoCode> bestCode = getBestCode(promoCodes, order);
        if (bestCode.isPresent()) {
            PromoCode code = bestCode.get();
            if (applyCode(code, order.getId())) {
                return order.applyDiscount(code.getDiscount(), code.getCode());
            } else {
                log.error("Ошибка применения промокода {}. Заказ {}", code.getCode(), order.getId());
                List<String> codes = promoCodes.stream().filter((c) -> !c.equals(code.getCode())).toList();
                if (!codes.isEmpty()) {
                    log.info("Пробуем применить другой промокод в заказе {}, codes: {}", order.getId(), codes);
                    return applyDiscount(order, codes);
                }
                log.info("Больше промокодов нет {}, Заказ {}", promoCodes, order.getId());
                return false;
            }
        } else {
            log.error("Заказ {}. Не удалось найти активные промокоды в списке {}", order.getId(), promoCodes);
        }
        return false;
    }

    private boolean applyCode(PromoCode code, String orderId) {
        log.info("Применяем промокод {} на скидку {}% в заказе {}",
                code.getCode(), code.getDiscount(), orderId);
        return code.setIsUsedPromocode();
    }

    private Optional<PromoCode> getBestCode(List<String> codes, Order order) {
        return activePromocodes.entrySet().stream()
                .filter(entry -> codes.contains(entry.getKey()) && entry.getValue().isValidForOrder(order.getTotalPrice()))
                .map(Map.Entry::getValue).max(Comparator.comparingDouble(PromoCode::getDiscount));
    }
}
