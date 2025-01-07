package school.faang.sprint_4.task_51094;

import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeliveryService {
    private static final String PROMOCODE_NOT_FOUND_VALID_EXCEPTION_MESSAGE = "No valid promo codes found";

    private final Map<String, PromoCode> promoCodes = new HashMap<>();
    private final Queue<Order> processedOrders = new ConcurrentLinkedQueue<>();
    private final Lock lock = new ReentrantLock();

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.put(promoCode.getCode(), promoCode);
    }

    public void processOrder(@NonNull Order order) throws OrderException {
        processOrder(order, null);
    }

    public void processOrder(@NonNull Order order, Set<String> promoCodes) throws OrderException {
        if (promoCodes != null && !promoCodes.isEmpty()) {
            PromoCode usefulPromoCode;
            lock.lock();
            try {
                usefulPromoCode = findMostProfitablePromoCode(order, promoCodes);
                this.promoCodes.remove(usefulPromoCode.getCode());
            } finally {
                lock.unlock();
            }
            order.applyDiscount(usefulPromoCode.getDiscount());
            usefulPromoCode.markAsUsed();
        }

        processedOrders.add(order);
    }


    private PromoCode findMostProfitablePromoCode(@NonNull Order order, @NonNull Set<String> promoCodes) {
        return promoCodes.stream()
                .filter(this.promoCodes::containsKey)
                .map(this.promoCodes::get)
                .filter(promoCode -> promoCode.isValidForOrder(order))
                .sorted((promoCode1, promoCode2) -> promoCode2.getDiscount() - promoCode1.getDiscount())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(PROMOCODE_NOT_FOUND_VALID_EXCEPTION_MESSAGE));
    }

    public Map<String, PromoCode> getPromoCodes() {
        return Map.copyOf(promoCodes);
    }

    public List<Order> getProcessedOrders() {
        return List.copyOf(processedOrders);
    }
}
