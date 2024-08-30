package faang.school.godbless.BJS2_25442;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Getter
public class DeliveryService {
    Map<String, PromoCode> promoCodes = new ConcurrentHashMap<>();
    List<Order> doneOrders = new CopyOnWriteArrayList<>();

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.put(promoCode.getCode(), promoCode);
    }

    public void processOrder(Order order, List<String> promoCodesList) {
        log.info("Started processing order {}", order);
        promoCodesList.stream()
                .filter(code -> promoCodes.containsKey(code))
                .map(code -> promoCodes.get(code))
                .filter(promo -> promo.isValidForOrder(order.getTotalPrice()))
                .max(Comparator.comparingDouble(PromoCode::getDiscount))
                .map(promo -> {
                    log.info("Promo {} was applied", promo);
                    order.applyDiscount(promo.getDiscount());
                    promo.setPromoCodeAsUsed();
                    log.info("Promo is deactivated: {}", promo);
                    return true;
                })
                .orElseGet(() -> {
                    log.info("No valid promo codes found for order {}", order);
                    return false;
                });

        doneOrders.add(order);
    }
}
