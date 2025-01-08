package derschrank.sprint04.task25.bjstwo_51104;

import derschrank.sprint04.task25.bjstwo_51104.units.PromoCode;
import derschrank.sprint04.task25.bjstwo_51104.units.Order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DeliveryService {
    private final Map<String, PromoCode> promoCodes;
    private final Set<PromoCode> usedPromoCodes;
    private final List<Order> processedOrders;

    public DeliveryService() {
        promoCodes = new ConcurrentHashMap<>();
        processedOrders = new ArrayList<>();
        usedPromoCodes = ConcurrentHashMap.newKeySet();
    }

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.put(promoCode.getCode(), promoCode);
    }

    public void processOrder(Order order, List<String> usersPromoCodes) {
        if (!order.isProcessed()) {
            implementPromoCode(order, usersPromoCodes);
            order.processing();
            processedOrders.add(order);
            toDelivery(order);
        }
    }

    private void implementPromoCode(Order order, List<String> usersPromoCodes) {
        if (!promoCodes.isEmpty()
                && !order.hasDiscount()) {
            Optional<PromoCode> promoOpt = usersPromoCodes.stream()
                    .map(promoCodes::get)
                    .filter(promo -> promo.isValidForOrder(order))
                    .max(Comparator.comparing(PromoCode::getDiscount));

            promoOpt.ifPresent(promo -> usePromoCodeForOrder(promo, order));
        }
    }

    private void usePromoCodeForOrder(PromoCode promoCode, Order order) {
        if (promoCode.markAsUsed(order)) {
            //System.out.printf("Using promo: %s for order: %s%n", promoCode, order);
            order.applyDiscount(promoCode);
            promoCodes.remove(promoCode);
            usedPromoCodes.add(promoCode);
        }
    }

    private void toDelivery(Order order) {
        System.out.printf(
                "To delivery: %s, price: %.2f, discount: %d, price with discount %.2f (promo: %s) is processed.%n",
                order.getNumber(),
                order.getTotalPrice(),
                order.getDiscount(),
                order.getTotalPriceWithDiscount(),
                (order.getPromoCodeOpt().isPresent() ? "**" + order.getPromoCodeOpt().get().getCode() + "**" : "none")
        );
    }

    public List<PromoCode> getAllActivePromoCodes() {
        return new ArrayList<>(promoCodes.values());
    }
}
