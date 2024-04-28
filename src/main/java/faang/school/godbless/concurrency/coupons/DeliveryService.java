package faang.school.godbless.concurrency.coupons;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@Slf4j
public class DeliveryService {
    private Set<Promocode> activePromoCodes = new CopyOnWriteArraySet<>();
    private List<Order> orders = new CopyOnWriteArrayList<>();

    public void addPromocode(@NonNull Promocode newPromocode) {
        activePromoCodes.add(newPromocode);
        log.info("Added new " + newPromocode);
    }

    private void addOrder(@NonNull Order newOrder) {
        orders.add(newOrder);
        log.info("Added new " + newOrder);
    }

    public synchronized void processOrder(Order order, List<Promocode> promoCodes) {
        var mostOptimalPromoCode = promoCodes.stream()
                .filter(activePromoCodes::contains)
                .filter(promocode -> promocode.isValidForOrder(order))
                .sorted()
                .findFirst();

        mostOptimalPromoCode.ifPresent(promocode -> {
            order.applyDiscount(promocode);
            activePromoCodes.remove(promocode);
        });

        addOrder(order);
    }

    public synchronized void printOrdersList() {
        log.info("Orders list:");
        orders.forEach(order -> log.info(order.toString()));
    }

    public synchronized void printActivePromocodes() {
        log.info("Active promocodes list:");
        activePromoCodes.forEach(promocode -> log.info(promocode.toString()));
    }
}
