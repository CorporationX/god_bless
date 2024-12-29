package school.faang.sprint_4.task_51112;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Slf4j
public class DeliveryService {
    private final ReentrantLock ordersLock = new ReentrantLock();
    private final ReentrantLock promoCodeLock = new ReentrantLock();
    private final Set<PromoCode> promoCodes;
    private final List<Order> orders;

    public DeliveryService() {
        promoCodes = new CopyOnWriteArraySet<>();
        orders = new CopyOnWriteArrayList<>();
    }

    public void addPromoCode(PromoCode promoCode) {
        ValidationUtils.isNotNull(promoCode, "Промокод");
        promoCodeLock.lock();
        try {
            log.info("Промокод №{} добавлен в список", promoCode.getCode());
            promoCodes.add(promoCode);
        } finally {
            promoCodeLock.unlock();
        }
    }

    public void processOrder(Order order) {
        ValidationUtils.isNotNull(order, "Заказ");

        promoCodeLock.lock();
        try {
            Optional<PromoCode> filteredPromoCode = promoCodes.stream()
                    .filter(promoCode -> {
                        boolean isValid = promoCode.isValidForOrder(order);
                        if (!isValid) {
                            log.info("Промокод №{} не соответствует условиям проверки для заказа №{}: {}",
                                    promoCode.getCode(),
                                    order.getId(),
                                    promoCode.getInvalidReason(order));
                        }
                        return isValid;
                    })
                    .max(Comparator.comparing(PromoCode::getDiscount));

            filteredPromoCode.ifPresent(promoCode -> {
                log.info("Применен промокод №{} с наилучшей скидкой в {}% для заказа №{}",
                        promoCode.getCode(),
                        promoCode.getDiscount(),
                        order.getId());
                double priceWithDiscount = order.applyDiscount(promoCode.getDiscount());
                log.info("Теперь цена заказа №{} составляет {} вместо {}",
                        order.getId(),
                        priceWithDiscount,
                        order.getTotalPrice());

                promoCode.markAsUsed();
                promoCodes.remove(promoCode);
                log.info("Промокод №{} удален из списка", promoCode.getCode());
            });
        } finally {
            promoCodeLock.unlock();
        }

        ordersLock.lock();
        try {
            log.info("Заказ №{} добавлен в список завершенных", order.getId());
            orders.add(order);
        } finally {
            ordersLock.unlock();
        }
    }
}
