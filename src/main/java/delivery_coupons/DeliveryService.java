package delivery_coupons;

import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class DeliveryService {
    private volatile List<PromoCode> activePromoCodes = new CopyOnWriteArrayList<>();
    private volatile Map<Order, String> processedOrders = new ConcurrentHashMap<>();

    public synchronized void processOrder(Order order) {
        Optional<PromoCode> suitablePromo = activePromoCodes.stream()
                .filter(promoCode -> promoCode.isValidForOrder(order))
                .max(Comparator.comparing(PromoCode::getDiscount));
        if (suitablePromo.isPresent()) {
            suitablePromo.get().setIsUsed();
            order.applyDiscount(suitablePromo.get());
            activePromoCodes.removeIf(promoCode -> promoCode.equals(suitablePromo.get()));
            processedOrders.put(order, "Promocode " + suitablePromo.get().getCode() + " applied");
        } else {
            processedOrders.put(order, "Without promo");
        }
    }

    public void addPromoCodes(List<PromoCode> promoCodes) {
        activePromoCodes = promoCodes;
    }
}
