package bjs261938;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@AllArgsConstructor
@Getter
public class OrderProcessor {
    private static final int THREAD_SLEEP_IN_MS = 3000;
    private static final int AWAIT_TERMINATION_IN_MS = 3000;
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(THREAD_SLEEP_IN_MS);
                        order.setStatus(Status.PROCESSED);
                        totalProcessedOrders.incrementAndGet();
                    } catch (InterruptedException e) {
                        log.error("{} interrupted", Thread.currentThread().getId(),
                                new OrderException("InterruptedException", e));
                        Thread.currentThread().interrupt();
                    }
                    return order;
                }, executorService)
                .handle((result, exception) -> {
                    if (!result.getStatus().equals(Status.PROCESSED)) {
                        throw new OrderException("Status.PROCESSED has not installed");
                    }
                    return result;
                });
    }

    public List<CompletableFuture<Order>> processAllOrders(List<Order> orders) {
        return orders.stream()
                .map(this::processOrder)
                .toList();
    }

    public void shutDownExecutorService() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_IN_MS, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
