package school.faang.bjs2_75964;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

@Slf4j
public class DeliveryService {
    private final Set<PromoCode> promoCodesActive =
            new ConcurrentSkipListSet<>(Comparator.comparing(PromoCode::getCode));
    private final Queue<Order> processedOrders = new ConcurrentLinkedQueue<>();

    public void addPromoCode(PromoCode promoCode) {
        checkNull(promoCode);
        if (promoCode.getIsUsed().get()) {
            log.error("Promo code {} is used", promoCode.getCode());
            throw new PromoCodeIsUsedException(promoCode.getCode());
        }
        boolean isAdd = promoCodesActive.add(promoCode);
        if (isAdd) {
            log.info("Promo code {} added", promoCode.getCode());
        } else {
            log.error("Promo code {} already exists", promoCode.getCode());
            throw new PromoCodeAlreadyExistsException(promoCode.getCode());
        }
    }

    public void processOrder(Order order, List<PromoCode> promoCodes) {
        checkNull(order);
        checkNull(promoCodes);
        promoCodes.forEach(this::checkNull);
        if (order.getIsDiscount().get()) {
            log.error("Discount already applied to order {}", order.getNumber());
            throw new DiscountAlreadyAppliedToOrderException(order.getNumber());
        }
        PromoCode bestPromoCode = promoCodes.stream()
                .filter(promoCodesActive::contains)
                .filter(promoCode -> promoCode.isValidForOrder(order))
                .max(Comparator.comparingDouble(PromoCode::getDiscount))
                .orElseThrow(() -> {
                    log.error("Proper promo code not found");
                    return new PromoCodeNotFoundException();
                });

        bestPromoCode.markAsUsed();
        order.applyDiscount(bestPromoCode.getDiscount());
        log.info("Apply discount {} for order {}", bestPromoCode.getDiscount(), order.getNumber());
        promoCodesActive.remove(bestPromoCode);
        processedOrders.add(order);
    }

    private <T> void checkNull(T object) {
        if (object == null) {
            log.error("Param in delivery service is null");
            throw new ParamInDeliveryServiceIsNullException();
        }
    }
}
