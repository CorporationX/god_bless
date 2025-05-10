package school.faang.bjs2_75964;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_75964.exception.ParamInDeliveryServiceIsNullException;
import school.faang.bjs2_75964.exception.PromoCodeAlreadyExistsException;
import school.faang.bjs2_75964.exception.PromoCodeIsUsedException;
import school.faang.bjs2_75964.exception.PromoCodeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class DeliveryService {
    private final Set<PromoCode> promoCodesActive =
            new ConcurrentSkipListSet<>(Comparator.comparing(PromoCode::getCode));
    private final Queue<Order> processedOrders = new ConcurrentLinkedQueue<>();
    private final ReentrantLock lock = new ReentrantLock();

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
        checkNull(order, promoCodes);
        if (order.getIsDiscount().get()) {
            log.error("Discount already applied to order {}", order.getNumber());
            throw new DiscountAlreadyAppliedToOrderException(order.getNumber());
        }
        PromoCode bestPromoCode = getBestPromoCode(order, promoCodes);

        applyDiscount(order, bestPromoCode);
    }

    private PromoCode getBestPromoCode(Order order, List<PromoCode> promoCodes) {
        return promoCodes.stream()
                .filter(promoCodesActive::contains)
                .filter(promoCode -> promoCode.isValidForOrder(order))
                .max(Comparator.comparingDouble(PromoCode::getDiscount))
                .orElseThrow(() -> {
                    log.error("Proper promo code not found");
                    return new PromoCodeNotFoundException();
                });
    }

    private void applyDiscount(Order order, PromoCode bestPromoCode) {
        lock.lock();
        try {
            bestPromoCode.markAsUsed();
            double discountedPrice = order.applyDiscount(bestPromoCode.getDiscount());
            log.info("Apply discount {} for order {}, discounted price {}",
                    bestPromoCode.getDiscount(), order.getNumber(), discountedPrice);
            promoCodesActive.remove(bestPromoCode);
            processedOrders.add(order);
        } finally {
            lock.unlock();
        }
    }

    private <T> void checkNull(T object, List<?> objectList) {
        checkNull(object);
        checkNull(objectList);
        objectList.forEach(this::checkNull);
    }

    private <T> void checkNull(T object) {
        if (object == null) {
            log.error("Param in delivery service is null");
            throw new ParamInDeliveryServiceIsNullException();
        }
    }
}
