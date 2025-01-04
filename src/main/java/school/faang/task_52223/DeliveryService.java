package school.faang.task_52223;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Getter
public class DeliveryService {

    private Map<String, PromoCode> promoCodeStatus = new HashMap<>();
    private List<Order> processedOrders = new ArrayList<>();

    public void addPromoCode(PromoCode promoCode) {
        promoCodeStatus.put(promoCode.getCode(), promoCode);
    }

    public void processOrder(Order order, List<PromoCode> promoCodes) {
        List<PromoCode> validPromoCode = promoCodes.stream().filter(s -> s.isValidForOrder(order)).collect(Collectors.toList());
        log.info("Валидация к заказу пройдена!\nПроверяем максимальную скидку.\n");

        PromoCode promoCodeWithMAxDiscount = getMaxDiscount(validPromoCode);
        order.applyDiscount(promoCodeWithMAxDiscount.getDiscount());
        log.info("Максимальная скидка применена!");

        promoCodeWithMAxDiscount.markAsUsed();

        processedOrders.add(order);

        deletePromoCode(promoCodeWithMAxDiscount);
    }

    private PromoCode getMaxDiscount(List<PromoCode> promoCodes) {
        return promoCodes.stream()
                .max(Comparator.comparingDouble(PromoCode::getDiscount))
                .orElseThrow(() -> new NoSuchElementException("Нет подходящих промокодов"));
    }

    private void deletePromoCode(PromoCode promoCode) {
        promoCodeStatus.remove(promoCode.getCode());
        log.info(String.format("Промокод №%s удален!", promoCode.getCode()));
    }

}
