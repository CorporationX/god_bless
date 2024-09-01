package faang.school.godbless.bjs2_24753;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int INIT_VALUE = 0;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(INIT_VALUE);
    private final ExecutorService executorService;

    public OrderProcessor(int threadPoolSize) {
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            sleepThread();
            order.setStatus(1);
            totalProcessedOrders.incrementAndGet();
            log.info("Order {} was processed", order.getId());
        }, executorService);
    }

    public void finish() {
        executorService.shutdown();
    }

    public int getNumbersProcessedOrders() {
        return totalProcessedOrders.get();
    }

    private void sleepThread() {
        try {
            Thread.sleep(1_000L);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
    }
}
