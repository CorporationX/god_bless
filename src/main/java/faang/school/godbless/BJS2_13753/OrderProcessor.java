package faang.school.godbless.BJS2_13753;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Slf4j
public class OrderProcessor {
    private static final long ORDER_PROCESSING_TIME = 1000L;
    public static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(ORDER_PROCESSING_TIME);
            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
            order.setStatus("Processed");
            totalProcessedOrders.incrementAndGet();
        }, EXECUTOR);
    }
}
