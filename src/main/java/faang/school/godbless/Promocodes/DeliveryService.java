package faang.school.godbless.Promocodes;

import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
public class DeliveryService {
    private Set<PromoCode> activePromoCodes = Collections.synchronizedSet(new HashSet<>());
    private List<Order> activeOrders = Collections.synchronizedList(new ArrayList<>());

    public void add(PromoCode promoCode) {
        activePromoCodes.add(promoCode);
    }

    public synchronized void processOrder(Order order, List<String> promoCodes) {
        List<PromoCode> sortedPromos = activePromoCodes.stream()
                .filter(promoCode -> promoCode.isValidForOrder(order))
                .sorted((v1, v2) -> v2.getDiscount() - v1.getDiscount())
                .toList();

        if (!sortedPromos.isEmpty()) {
            PromoCode bestAvailablePromo = sortedPromos.get(0);
            bestAvailablePromo.setIsUsed();
            activePromoCodes.remove(bestAvailablePromo);
            System.out.println("добавил промокод к заказу со стоимостью " + order.getTotalPrice());
            order.applyDiscount(bestAvailablePromo);
        } else {
            System.out.println("No promo code found");
        }

        activeOrders.add(order);
        System.out.println("Добавил заказ. С учётом скидки (если есть) цена составила: " + order.getTotalPrice());
    }
}
