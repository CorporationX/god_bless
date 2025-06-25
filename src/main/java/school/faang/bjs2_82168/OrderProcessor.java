package school.faang.bjs2_82168;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int TWO_SECOND_IN_MS = 2000;

    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(TWO_SECOND_IN_MS);
                order.setStatus("Processing");
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
