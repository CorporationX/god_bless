package faang.school.godbless.delivery;

import lombok.Getter;
import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

public class DeliveryService {
    private final Set<PromoCode> activePromoCodes = new ConcurrentSkipListSet<>();
    @Getter
    private final Queue<Order> processedOrders = new ConcurrentLinkedQueue<>();

    public void addActivePromoCode(PromoCode promoCode) {
        activePromoCodes.add(promoCode);
    }

    public synchronized void processOrder(@NonNull Order order, @NonNull List<String> promoCodes) {
        Optional<PromoCode> bestPromoCode = findBestPromoCode(order, promoCodes);
        bestPromoCode.ifPresent((promoCode) -> {
            order.applyDiscount(promoCode.getDiscount());
            promoCode.setIsUsed();
            activePromoCodes.remove(promoCode);
        });
        processedOrders.add(order);
    }


    private Optional<PromoCode> findBestPromoCode(@NonNull Order order, @NonNull List<String> promoCodes) {
        return activePromoCodes.stream()
                .filter((promoCode) -> promoCodes.contains(promoCode))
                .filter(promoCode -> promoCode.isValidForOrder(order))
                .max(Comparator.comparingDouble(PromoCode::getDiscount));
    }
}
