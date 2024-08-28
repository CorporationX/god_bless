package faang.school.godbless.AmazonOrders;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    public static AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(5) * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalProcessedOrders.incrementAndGet();
            order.setStatus("Обработано");
            return order;
        }, executorService);
    }
}
