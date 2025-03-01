package bjs2_63072;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
public class DeliveryService {
    private final Map<String, PromoCode> promoCodes = new ConcurrentHashMap<>();
    // В задаче было сказано, что нужно использовать список,
    // но тогда придётся добавлять какой-то объект синхронизации, чтобы можно было в одном потоке добавлять заказы,
    // а в другом считывать выполненные заказы, поэтому я решил использовать ConcurrentLinkedQueue,
    // тем более, что в подсказках было сказано, что это вариант улучшения
    private final ConcurrentLinkedQueue<Order> processedOrders = new ConcurrentLinkedQueue<>();

    public boolean addPromoCode(PromoCode promoCode) {
        var prevValue = promoCodes.putIfAbsent(promoCode.getCode(), promoCode);

        return prevValue == null;
    }

    public void processOrder(Order order, List<String> promoCodes) {
        // При написании кода я предположил, что в списке promoCodes должны быть все уже ранее добавленные промо коды.
        // Т.е. при такой последовательности вызова
        // processOrder(order, List.of("super25", "success30", ...));
        // addPromoCode(new PromoCode("super25", ...));
        // промо код не должен примениться.
        // Если же эти 2 строки будут вызваны из разных потоков именно в такой последовательности,
        // то код либо примениться, либо нет - как повезёт.
        // Такое поведение позволит не добавлять блокировку на хэш-таблицы promoCodes.
        var sortedByDiscountPromoCodes = this.promoCodes
                .values()
                .stream()
                // Исключаем сразу недоступные коды, т.к. применить код можно только 1 раз
                .filter(x -> x.isValidForOrder(order) && promoCodes.contains(x.getCode()))
                // Обрабатываем коды в порядке убывания скидки
                .sorted((x, y) -> Double.compare(y.getDiscount(), x.getDiscount()))
                .toList();

        for (var promoCode : sortedByDiscountPromoCodes) {
            // markAsUsed атомарно помечает код использованным только, если он ещё не использован,
            // это так же позволяет не добавлять не нужные объекты синхронизации.
            // Хотя можно было использовать результат вызова this.promoCodes.remove,
            // чтобы понять, что код уже применён,
            // но тогда мы размазываем механизм исключения повторного использования кодов в разные классы,
            // что не круто.
            if (promoCode.markAsUsed()) {
                // Код можно применить => удаляем его
                this.promoCodes.remove(promoCode.getCode());
                log.info("Применён промо код {}", promoCode.getCode());
                order.applyDiscount(promoCode.getDiscount());
                break;
            }
        }

        processedOrders.add(order);
    }

    public void showProcessedOrders() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append("Обработанные заказы").append(System.lineSeparator());
        for (var order : processedOrders) {
            stringBuilder.append(String.format(
                            "Заказ %s",
                            String.join(", ", order.products().stream().map(Product::name).toList())))
                    .append(System.lineSeparator());
        }

        log.info(stringBuilder.toString());
    }
}
