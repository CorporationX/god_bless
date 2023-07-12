package faang.school.godbless.sprint_3.multithreading_future.amazon_orders_collecting;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            System.out.printf("Начинаем делать заказ за номер %d%n", order.getId());
            order.setStatus(OrderStatus.IN_PROGRESS);
            int random = ThreadLocalRandom.current().nextInt(6) * 1000;
            try {
                Thread.sleep(random);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            System.out.printf("Заказ за номер %d успешно выполнен%n", order.getId());
            order.setStatus(OrderStatus.DONE);
            totalProcessedOrders.incrementAndGet()
            ;
        });
    }
}