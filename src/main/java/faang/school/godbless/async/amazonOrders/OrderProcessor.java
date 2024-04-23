package faang.school.godbless.async.amazonOrders;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final Long ORDER_PROCESSING_TIME = 3000L;
    private static final ExecutorService processingThreads = Executors.newCachedThreadPool();
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);


    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(ORDER_PROCESSING_TIME);
                    } catch (InterruptedException e) {
                        log.error("Order (" + order.getId() + ") processing was interrupted.", e);
                    }

                    return order;
                }, processingThreads)
                .thenApply((orderAfterProcessing) -> orderAfterProcessing.setStatus(OrderStatus.PROCESSED))
                .thenRun(() -> totalProcessedOrders.incrementAndGet());
    }

    public int getTotalProcessedOrdersAmount() {
        return totalProcessedOrders.intValue();
    }

    public void shutdownThreadPool() {
        processingThreads.shutdown();
    }
}
