package faang.school.godbless.BJS2_25460;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@Getter
public class DeliveryService {
    private Map<String, PromoCode> promoCodes = new ConcurrentHashMap<>();
    private ConcurrentLinkedQueue<Order> orders = new ConcurrentLinkedQueue<>();

    public void putPromoCode(PromoCode promoCode) {
        promoCodes.put(promoCode.getCode(), promoCode);
    }

    public void processOrder(Order order, Set<String> codes) {
        System.out.println("Processing order: " + order.getId());

        List<PromoCode> promoCodes = codesToPromoCodes(codes);
        List<PromoCode> maxPromoCodes = PromoCode.sortValidPromoCodesForOrder(order, promoCodes);
        if (!tryUsePromoCode(order, maxPromoCodes)) {
            System.out.println("No active promo code for order: " + order.getId());
        }

        orders.add(order);
        System.out.println("Order processed: " + order.getId());
    }

    private List<PromoCode> codesToPromoCodes(Set<String> codes) {
        return codes.stream()
                .map(promoCodes::get)
                .toList();
    }

    private boolean tryUsePromoCode(Order order, List<PromoCode> promoCodes) {
        for (PromoCode promoCode : promoCodes) {
            synchronized (promoCode.getLock()) {
                if (!promoCode.isUsed()) {
                    order.applyDiscount(promoCode);
                    return true;
                }
            }
        }
        return false;
    }
}
