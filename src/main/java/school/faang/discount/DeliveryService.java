package school.faang.discount;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class DeliveryService {
    private final List<PromoCode> promoCodes = Collections.synchronizedList(new ArrayList<>());
    private final List<Order> processedOrders = Collections.synchronizedList(new ArrayList<>());

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.add(promoCode);
    }

    public synchronized void processOrder(Order order, List<PromoCode> promoCodesList) {
        double maxPromoDiscount = 0.0;
        PromoCode flag = null;
        for (PromoCode promoCode : promoCodesList) {
            if (promoCode.isValidForOrder(order) && maxPromoDiscount < promoCode.getDiscount()) {
                maxPromoDiscount = promoCode.getDiscount();
                flag = promoCode;
            }
        }
        if (flag != null) {
            order.applyDiscount(maxPromoDiscount);
            flag.markAsUsed();
            promoCodes.remove(flag);
        }

        processedOrders.add(order);
    }
}
