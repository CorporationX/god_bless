package school.faang.task_51123;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class DeliveryService {
    private final Object promoCodeLock = new Object();
    private final ConcurrentMap<UUID, PromoCode> promoCodes = new ConcurrentHashMap<>();
    private final ConcurrentMap<UUID, Order> processedOrders = new ConcurrentHashMap<>();

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.put(promoCode.getPromoCodeId(), promoCode);
    }

    public void processOrder(Order order, List<String> userPromoCodes) {
        synchronized (promoCodeLock) {
            Set<PromoCode> availablePromoCodes = getAvailablePromoCodes(order, userPromoCodes);

            if (!availablePromoCodes.isEmpty()) {
                PromoCode profitPromoCode = availablePromoCodes.stream()
                        .max(Comparator.comparingDouble(PromoCode::getDiscount))
                        .get();

                order.applyDiscount(profitPromoCode.getDiscount());
                profitPromoCode.markAsUsed();
            }
        }
        processedOrders.put(order.getOrderId(), order);
    }

    private Set<PromoCode> getAvailablePromoCodes(Order order, List<String> userPromoCodes) {
        return promoCodes.values().stream()
                .filter(promoCode ->
                        promoCode.isValidForOrder(order) && userPromoCodes.contains(promoCode.getCode()))
                .collect(Collectors.toSet());
    }
}
