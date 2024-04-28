package faang.school.godbless.bjs2_6157;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class DeliveryService {

    private final Set<PromoCode> activePromoCodes = new ConcurrentSkipListSet<>();
    private final List<Order> processedOrders = new CopyOnWriteArrayList<>();

    public void addActivePromoCode(PromoCode promoCode) {
        activePromoCodes.add(promoCode);
    }

    public synchronized void processOrder(Order order, List<String> promoCodes) {
        Optional<PromoCode> bestPromo = findBestPromoCode(order, promoCodes);
        if (bestPromo.isPresent()) {
            order.applyDiscount(bestPromo.get().getDiscount());
            log.info("The cost of the order {} with a {}% discount was {} rub.", order.getId(), bestPromo.get().getDiscount(), order.getTotalPrice());

            bestPromo.get().setIsUsed();
        } else {
            log.info("The order {} cost was {} rub.", order.getId(), order.getTotalPrice());
        }
        processedOrders.add(order);
    }

    private Optional<PromoCode> findBestPromoCode(Order order, List<String> promoCodes) {
        return activePromoCodes.stream()
                .filter(code -> promoCodes.contains(code.getCode())) // пропустить промокоды из переданного списка
                .filter(code -> code.isValidForOrder(order)) // пропустить валидные промокоды для заказа
                .max(Comparator.comparing(PromoCode::getDiscount));
    }

    public void printProcessedOrders() {
        System.out.println("Processed orders:");
        processedOrders
                .forEach(order -> {
                    System.out.println("Order - " + order.getId());
                    order.getProducts()
                            .forEach(System.out::println);
                });
    }
}
