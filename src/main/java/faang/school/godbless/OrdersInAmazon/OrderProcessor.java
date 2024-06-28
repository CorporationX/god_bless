package faang.school.godbless.OrdersInAmazon;

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    @Getter
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processOrder(Order order) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(5));
        } catch (InterruptedException e) {
            throw new RuntimeException("Ошибка в обработке заказа");
        }
        order.setStatus("Обработано");
        totalProcessedOrders.incrementAndGet();
    }
}
