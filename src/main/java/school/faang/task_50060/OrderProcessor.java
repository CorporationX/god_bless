package school.faang.task_50060;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static school.faang.task_50060.Status.DONE;

@Slf4j
public class OrderProcessor {
    private static final int TWO_SECOND = 2_000;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processAllOrders(List<Order> orders) {
        CompletableFuture.allOf(
                        orders.stream()
                                .map(this::processOrder)
                                .toList().toArray(new CompletableFuture[]{}))
                .join();
    }

    @SneakyThrows
    public CompletableFuture<Order> processOrder(Order order) {
        log.info("Start processing order: {}", order.getId());
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TWO_SECOND);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus(DONE);
            log.info("Order: {} change status: {}", order.getId(), order.getStatus());
            totalProcessedOrders.incrementAndGet();
            log.info("Total processed orders: {}", totalProcessedOrders.get());
            return order;
        });
    }
}
