package school.faang.delivery.coupon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DeliveryService {
    private final ConcurrentHashMap<String, PromoCode> promoCodes = new ConcurrentHashMap<>();
    private final List<Order> processedOrders = new CopyOnWriteArrayList<>();

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.put(promoCode.getCode(), promoCode);
    }

    public void processOrder(Order order, List<String> promoCodes) {
        Optional<PromoCode> bestPromo = promoCodes.stream()
                .map(this.promoCodes::get)
                .filter(Objects::nonNull)
                .filter(promo -> promo.isValidForOrder(order))
                .max(Comparator.comparingDouble(PromoCode::getDiscount));

        bestPromo.ifPresent(promo -> {
            if (promo.markAsUsed()) {
                order.applyDiscount(promo.getDiscount());
                this.promoCodes.remove(promo.getCode());
            }
        });

        processedOrders.add(order);
    }

    public List<Order> getProcessedOrders() {
        return new ArrayList<>(processedOrders);
    }
}
