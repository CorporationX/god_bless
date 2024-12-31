package school.faang.bjs250080;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
public class OrderProcessor {

    private static final int ORDER_PROCESSING_TIME = 3000;
    @Getter
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService executorService;

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {

            try {
                if (order.getStatus().equals(Status.NEW) || order.getStatus().equals(Status.AT_WORK)) {

                    log.info("Order processing with id {} has started", order.getId());
                    Thread.sleep(ORDER_PROCESSING_TIME);
                    order.setStatus(Status.DONE);
                    totalProcessedOrders.incrementAndGet();
                }
            } catch (InterruptedException e) {
                log.error("The tread {} was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
        }, executorService);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> completableFutures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture
                .allOf(completableFutures.toArray(CompletableFuture[]::new));
        allFutures.join();
    }
}