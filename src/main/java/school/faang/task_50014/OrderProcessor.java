package school.faang.task_50014;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
public class OrderProcessor {
    private static final int ORDER_PROCESSING_SIMULATION_DELAY = 3000;

    private final ExecutorService executorService;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> processAllOrders = orders.stream()
                .map(this::processOrder).toList();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        processAllOrders.forEach(CompletableFuture::join);

        log.info("Total processed orders: {}", totalProcessedOrders.get());
    }

    private CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Processing of order number {} has begun", order.getId());
            try {
                Thread.sleep(ORDER_PROCESSING_SIMULATION_DELAY);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.addAndGet(1);
            return order;
        }, executorService);
    }
}
