package school.faang.bjs2_93185;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import static school.faang.bjs2_93185.TypeOrder.PROCESSED;

@Slf4j
public class OrderProcessor {
    private static final int DEFAULT_TIME_SLEEP = 2000;
    private AtomicInteger totalProcessedOrders = new AtomicInteger();

    public int totalProcessedOrders() {
        return totalProcessedOrders.get();
    }

    public synchronized CompletableFuture<Order> processOrder(Order order) {
        CompletableFuture<Order> future = CompletableFuture.supplyAsync(() -> {
            sleepThread();
            totalProcessedOrders.incrementAndGet();
            return order;
        });
        order.setStatus(PROCESSED);
        return future;
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> futures = new ArrayList<>();
        orders.forEach(order -> {
            CompletableFuture<Order> future = processOrder(order);
            log.info("Закак обработан {}", order);
            futures.add(future);
        });
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        try {
            allFutures.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private void sleepThread() {
        try {
            Thread.sleep(DEFAULT_TIME_SLEEP);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
