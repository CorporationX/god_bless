package fooddelivery;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.Comparator;

@Slf4j
public class DeliveryService {
    private final ConcurrentMap<String, PromoCode> activePromoCodes = new ConcurrentHashMap<>();
    private final List<Order> processedOrders = Collections.synchronizedList(new ArrayList<>());

    public void addPromoCode(PromoCode promoCode) {
        activePromoCodes.put(promoCode.getCode(), promoCode);
    }

    public void processOrder(Order order, List<String> promoCodeStrings) {
        PromoCode bestPromo = promoCodeStrings.stream()
                .map(activePromoCodes::get)
                .filter(pc -> pc != null && pc.isValidForOrder(order))
                .max(Comparator.comparingDouble(PromoCode::getDiscount))
                .orElse(null);

        if (bestPromo != null) {
            synchronized (bestPromo.getLock()) {
                if (bestPromo.isValidForOrder(order)) {
                    bestPromo.markAsUsed();
                    activePromoCodes.remove(bestPromo.getCode(), bestPromo);
                    order.applyDiscount(bestPromo.getDiscount());
                    log.info("Applied promo code {} ({}% off) to order. Total: {}, Discounted: {}",
                            bestPromo.getCode(), bestPromo.getDiscount(),
                            order.getTotalPrice(), order.getDiscountedPrice());
                } else {
                    log.info("Promo code {} is no longer valid for the order.", bestPromo.getCode());
                }
            }
        } else {
            log.info("No valid promo code applied. Order total: {}", order.getTotalPrice());
        }

        processedOrders.add(order);
    }

    public List<Order> getProcessedOrders() {
        return processedOrders;
    }
}
