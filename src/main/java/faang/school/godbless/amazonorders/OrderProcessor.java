package faang.school.godbless.amazonorders;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
                order.setStatus("Обработано");
                totalProcessedOrders.incrementAndGet();
                System.out.println("Обработан заказ: " + order.getId());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

