package faang.school.godbless.delivery_coupons;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.stream.Stream;

@Slf4j
@Getter
@ToString
public class DeliveryService {
    private final Map<String, PromoCode> activePromoCodeMap = new ConcurrentHashMap<>();
    private final Queue<Order> processedOrders = new ConcurrentLinkedQueue<>();

    public void addPromoCode(PromoCode promoCode) {
        activePromoCodeMap.put(promoCode.getCode(), promoCode);
    }

    public void processOrder(Order order, List<String> promoCodes) {
        PromoCode mostMatchingPromoCode = getMostMatchingPromoCode(order, promoCodes);
        Lock promoCodeLock = mostMatchingPromoCode.getPromoCodeLock();

        promoCodeLock.lock();
        try {
            if (!mostMatchingPromoCode.isUsed()) {
                log.info("Getting payment in amount: " + order.applyDiscount(mostMatchingPromoCode));
                activePromoCodeMap.remove(mostMatchingPromoCode.getCode());
                processedOrders.add(order);
            } else {
                log.warn("Your promoCode was used just a few minutes ago. Try again");
            }
        } finally {
            promoCodeLock.unlock();
        }
    }

    private PromoCode getMostMatchingPromoCode(Order order, List<String> promoCodes) {
        Stream<PromoCode> allValidAndActivePromoCodesStream = promoCodes.stream()
                .filter(activePromoCodeMap::containsKey)
                .filter((promoCode) -> order.isValidPromoCode(activePromoCodeMap.get(promoCode), order.getTotalPrice()))
                .map(activePromoCodeMap::get);

        return allValidAndActivePromoCodesStream.max(Comparator.comparingDouble(PromoCode::getDiscount))
                .orElseThrow(() -> new IllegalArgumentException("No matching promoCode"));
    }
}
