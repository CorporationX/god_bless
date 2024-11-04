package school.faangSprint4.t25;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

public class DeliveryService {
    private final ConcurrentSkipListSet<PromoCode> promoCodes;
    private final ConcurrentLinkedQueue<Order> processedOrders;

    public DeliveryService() {
        this.promoCodes = new ConcurrentSkipListSet<>(
                Comparator.comparing(PromoCode::getCode)
        );
        this.processedOrders = new ConcurrentLinkedQueue<>();
    }

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.add(promoCode);
    }

    public void processOrder(Order order, List<String> promoCodeStrings) {
        PromoCode bestPromoCode = findBestValidPromoCode(order, promoCodeStrings);

        if (bestPromoCode != null) {
            if (bestPromoCode.markAsUsed()) {
                order.applyDiscount(bestPromoCode.getDiscount());
                promoCodes.remove(bestPromoCode);
            }
        }

        processedOrders.offer(order);
    }

    private PromoCode findBestValidPromoCode(Order order, List<String> promoCodeStrings) {
        return promoCodes.stream()
                .filter(promoCode -> promoCodeStrings.contains(promoCode.getCode()))
                .filter(promoCode -> promoCode.isValidForOrder(order))
                .max(Comparator.comparing(PromoCode::getDiscount))
                .orElse(null);
    }
}