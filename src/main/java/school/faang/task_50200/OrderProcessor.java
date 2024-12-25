package school.faang.task_50200;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final static long SLEEP_TIME = 10_000;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public int processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> allOrders = new ArrayList<>();
        orders.forEach((order) -> allOrders.add(processOrder(order)));

        CompletableFuture<Void> allDone = CompletableFuture.allOf(allOrders.toArray(new CompletableFuture[0]));
        allDone.join();

        return totalProcessedOrders.get();
    }

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Done";
        }).thenAccept((result) -> {
            order.setStatus(result);
            totalProcessedOrders.incrementAndGet();
        });
    }
}
