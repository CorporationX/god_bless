package school.faang.sprint_4.task_51073;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@RequiredArgsConstructor
public class DeliveryService {
    private final Map<String, PromoCode> promoCodes = new ConcurrentHashMap<>();
    private final List<Order> processedOrders = new CopyOnWriteArrayList<>();

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.put(promoCode.getCode(), promoCode);
    }

    public void processOrder(Order order, List<String> promoCodesStrings) {

        PromoCode promoCodeToApply = promoCodesStrings.stream()
                .map(promoCodes::get)
                .filter(promoCode -> promoCode.isValidForOrder(order))
                .max(Comparator.comparingDouble(PromoCode::getDiscount))
                .orElseThrow(IllegalStateException::new);

        order.applyDiscount(promoCodeToApply.getDiscount());
        processedOrders.add(order);
        promoCodeToApply.markAsUsed();
    }

    public List<String> getRandomPromoCodes() {
        List<String> promoCodesStrings = new ArrayList<>(promoCodes.keySet());

        Collections.shuffle(promoCodesStrings);
        return promoCodesStrings.stream()
                .limit(new Random().nextInt(promoCodes.size()))
                .toList();
    }
}
