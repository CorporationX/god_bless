package school.faang.deliverycoupons;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DeliveryService {
    private final Map<String, PromoCode> promoCodes = new ConcurrentHashMap<>();
    private final Queue<Order> processedOrders = new ConcurrentLinkedQueue<>();


    public void addPromoCode(PromoCode promoCode) {
        promoCodes.put(promoCode.getCode(), promoCode);
    }

    public void processOrder(Order order, List<String> promoCodesList) {
        Optional<PromoCode> bestPromo = promoCodesList.stream()
                .map(promoCodes::get)
                .filter(promoCode -> promoCode != null && promoCode.isValidForOrder(order))
                .max(Comparator.comparingDouble(PromoCode::getDiscount));

        if (bestPromo.isPresent()) {
            PromoCode promo = bestPromo.get();
            order.applyDiscount(promo.getDiscount());
            promo.markAsUsed();
            promoCodes.remove(promo.getCode());
            System.out.println("Applied promo code: " + promo.getCode() + " with " + promo.getDiscount() + "% discount.");
        } else {
            System.out.println("No valid promo code found.");
        }

        processedOrders.add(order);
    }
}
