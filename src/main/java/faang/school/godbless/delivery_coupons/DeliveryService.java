package faang.school.godbless.delivery_coupons;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class DeliveryService {
    private Map<String, Promocode> promocodesMap;
    private List<Order> processedOrders;

    public DeliveryService() {
        this.promocodesMap = new ConcurrentHashMap<>();
        this.processedOrders = new CopyOnWriteArrayList<>();
    }

    public void addNewPromocode(Promocode promococde) {
        if (!promocodesMap.containsKey(promococde.getCode())) {
            promocodesMap.put(promococde.getCode(), promococde);
        } else {
            log.error("Promocode with code {}, already exists", promococde.getCode());
        }
    }

    public void processOrder(Order order, List<String> promoCodes) {
        Optional<Promocode> optionalPromocode = findBestPromocode(order, promoCodes);

        optionalPromocode.ifPresentOrElse(promocode -> {
            boolean isSuccess = order.applyDiscount(promocode);
            if (!isSuccess) {
                log.error("Failed to apply promocode");
            } else {
                processedOrders.add(order);
                promocodesMap.remove(promocode.getCode());
                log.error("Promocode successfully applied");
            }
        }, () -> log.error("Failed to apply promocode"));
    }

    private Optional<Promocode> findBestPromocode(Order order, List<String> promoCodes) {
        return promocodesMap.entrySet().stream()
                .filter(entry -> promoCodes.contains(entry.getValue().getCode()))
                .filter(entry -> entry.getValue().getMinimumOrderValue() < order.getTotalPrice())
                .sorted(Comparator.comparingInt(o -> o.getValue().getDiscountPercentage()))
                .findFirst()
                .map(Map.Entry::getValue);
    }
}
