package school.faang.bjs_50055;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

@Slf4j
public class OrderProcessor {
    private static final int SLEEP_TIMEOUT = 1000;
    private final ExecutorService executor = Executors.newFixedThreadPool(10);
    @Getter
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Integer> processOrder(Order order) {
        return CompletableFuture.supplyAsync(processOrderTask(order), executor);
    }

    public void processAllOrders(List<Order> orders) {
        log.info("Starting processAllOrders");

        List<CompletableFuture<Integer>> futures = orders.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("Finished processAllOrders. Total processed orders: {}", totalProcessedOrders.get());
    }

    private Supplier<Integer> processOrderTask(Order order) {
        return () -> {
            log.info("Starting processing order {}", order);
            try {
                Thread.sleep(SLEEP_TIMEOUT);
            } catch (InterruptedException e) {
                log.error("Sleep interrupted", e);
            }
            order.setStatus(OrderStatus.COMPLETED);
            log.info("Finish processing order {}", order);
            return totalProcessedOrders.incrementAndGet();
        };
    }
}
