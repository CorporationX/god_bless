package faang.school.godbless.deliveryCoupons;

import lombok.Getter;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class DeliveryService {
    private final ConcurrentSkipListSet<PromoCode> activePromoCodes;
    private final ConcurrentLinkedQueue<Order> processedOrders;

    private final AtomicInteger orderIdCounter = new AtomicInteger(1);

    public DeliveryService() {
        activePromoCodes = new ConcurrentSkipListSet<>(Comparator.comparingDouble(PromoCode::getDiscount));
        processedOrders = new ConcurrentLinkedQueue<>();
    }

    public void addActivePromoCode(PromoCode promoCode) {
        activePromoCodes.add(promoCode);
    }

    public void processOrder(Order order, List<String> promoCodes) {
        PromoCode bestPromoCode = findBestPromoCode(promoCodes);
        if (bestPromoCode != null && bestPromoCode.isValidForOrder(order)) {
            order.applyDiscount(bestPromoCode);
            bestPromoCode.markAsUsed();
            activePromoCodes.remove(bestPromoCode);
            int orderId = orderIdCounter.getAndIncrement();
            System.out.println("Discount applied: " + bestPromoCode.getDiscount() + " for order Id" + orderId + ": " + order.getFormattedTotalPrice());
        } else {
            int orderId = orderIdCounter.getAndIncrement();
            System.out.println("No applicable discount for order Id" + orderId + ": " + order.getFormattedTotalPrice());
        }
        processedOrders.add(order);
    }

    private PromoCode findBestPromoCode(List<String> promoCodes) {
        PromoCode bestPromoCode = null;
        double maxDiscount = 0;
        for (String promoCode : promoCodes) {
            PromoCode code = activePromoCodes.stream()
                    .filter(pc -> pc.getCode().equals(promoCode))
                    .findFirst()
                    .orElse(null);
            if (code != null && code.getDiscount() > maxDiscount) {
                bestPromoCode = code;
                maxDiscount = code.getDiscount();
            }
        }
        return bestPromoCode;
    }

}
