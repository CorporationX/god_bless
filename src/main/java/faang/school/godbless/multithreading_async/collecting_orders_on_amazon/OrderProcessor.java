package faang.school.godbless.multithreading_async.collecting_orders_on_amazon;

import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public CompletableFuture<Order> processOrder(Order order) {

        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
                order.setStatus(1);// 1 - Обработано
                totalProcessedOrders.incrementAndGet();
                return order;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);
    }

    public void shutdownExecutor() {
        executorService.shutdown();
    }
}
