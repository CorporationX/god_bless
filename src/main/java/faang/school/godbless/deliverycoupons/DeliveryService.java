package faang.school.godbless.deliverycoupons;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
public class DeliveryService {
    private final Map<String, PromoCode> promoCodes;
    private final Queue<Order> processedOrders;

    public DeliveryService() {
        this.promoCodes = new ConcurrentHashMap<>();
        this.processedOrders = new ConcurrentLinkedQueue<>();
    }

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.putIfAbsent(promoCode.getCode(), promoCode);
    }

    public void processOrder(Order order, List<String> promoCodesList) {
        PromoCode bestPromoCode = findBestPromoCode(order, promoCodesList);
        if (bestPromoCode != null && bestPromoCode.use()) {
            order.applyDiscount(bestPromoCode.getDiscount());
            promoCodes.remove(bestPromoCode.getCode());
            log.info("Applied promo code: {}", bestPromoCode.getCode());
        } else {
            log.info("No valid promo code applied.");
        }
        processedOrders.add(order);
    }

    private PromoCode findBestPromoCode(Order order, List<String> promoCodesList) {
        return promoCodesList.stream()
                .map(promoCodes::get)
                .filter(promoCode -> promoCode != null && promoCode.isValidForOrder(order))
                .max(Comparator.comparingDouble(PromoCode::getDiscount))
                .orElse(null);
    }

    public void printProcessedOrders() {
        processedOrders.forEach(order -> System.out.println("Processed order: " + order.getTotalPrice()));
    }
}