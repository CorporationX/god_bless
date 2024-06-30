package faang.school.godbless.coupon;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class DeliveryService {
    private static final ConcurrentHashMap<String, PromoCode> ACTUAL_PROMO_CODE = new ConcurrentHashMap<>();

    public Map<Product, Integer> processOrder(Order order, List<String> promoCodes) {
        Map<Product, Double> foodBasket = new HashMap<>();
        Calendar date = GregorianCalendar.getInstance();
        var existingPromoCodes = promoCodes.stream()
                .filter(ACTUAL_PROMO_CODE::containsKey)
                .toList();
        Optional<String> coupon;
        double discount = 1;
        synchronized (this) {
            coupon = existingPromoCodes.stream()
                    .filter(promo -> ACTUAL_PROMO_CODE.get(promo).getNotUsed().get())
                    .filter(promo -> ACTUAL_PROMO_CODE.get(promo).getMinimumOrderValue() >= order.getAllCost())
                    .filter(promo -> date.before(ACTUAL_PROMO_CODE.get(promo).getExpirationDate()))
                    .max(Comparator.comparingDouble(promo -> ACTUAL_PROMO_CODE.get(promo).getDiscount()))
                    .orElse(" ").describeConstable();
            if (coupon.isPresent()) {
                discount = ACTUAL_PROMO_CODE.get(coupon.get()).getDiscount();
                ACTUAL_PROMO_CODE.remove(coupon.get());
            }
        }
        return order.getAllProductFromOrder().entrySet().stream()
                .forEach(entry -> entry.getKey().setDiscountForPrice(discount));
    }
}
