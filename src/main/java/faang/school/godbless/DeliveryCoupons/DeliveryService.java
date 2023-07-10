package faang.school.godbless.DeliveryCoupons;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;

@Data
@AllArgsConstructor
public class DeliveryService {
    private ConcurrentSkipListSet<PromoCode> availablePromoCodes;
    private ConcurrentLinkedQueue<Order> processedOrders;

    public DeliveryService(List<PromoCode> promoCodes) {
        this.availablePromoCodes = new ConcurrentSkipListSet<>();
        availablePromoCodes.addAll(promoCodes);
        this.processedOrders = new ConcurrentLinkedQueue<>();
    }

    public synchronized void processOrder(Order order, List<String> promoCodes) {
        AtomicBoolean successfullyProcessed = new AtomicBoolean(false);

        List<PromoCode> promoCodes1 = availablePromoCodes.stream()
                .filter(promo -> promoCodes.contains(promo.getCode()))
                .sorted(Comparator.comparing(PromoCode::getDiscount).reversed())
                .toList();

        promoCodes1.forEach(promoCode -> {
            if (!successfullyProcessed.get() && promoCode.isValidFor(order)) {
                order.applyDiscount(promoCode);
                promoCode.usePromoCode();
                availablePromoCodes.remove(promoCode);
                successfullyProcessed.set(true);
            }
        });

        processedOrders.add(order);
    }
}
