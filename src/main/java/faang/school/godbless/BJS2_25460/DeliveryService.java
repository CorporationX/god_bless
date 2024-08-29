package faang.school.godbless.BJS2_25460;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class DeliveryService {
    private Map<String, PromoCode> promoCodes = new ConcurrentHashMap<>();
    private Set<Order> orders = ConcurrentHashMap.newKeySet();

    public void putPromoCode(PromoCode promoCode) {
        promoCodes.put(promoCode.getCode(), promoCode);
    }

    public void processOrder(Order order, List<String> codes) {
        System.out.println("Processing order: " + order.getId());

        List<PromoCode> promoCodes = codesToPromoCodes(codes);
        synchronized (this) {
            Optional<PromoCode> maxPromoCode = PromoCode.findMaxValidPromoCodeForOrder(order, promoCodes);
            maxPromoCode.ifPresent(order::applyDiscount);
        }
        orders.add(order);

        System.out.println("Order processed: " + order.getId());
    }

    private List<PromoCode> codesToPromoCodes(List<String> codes) {
        return codes.stream()
                .map(promoCodes::get)
                .toList();
    }
}
