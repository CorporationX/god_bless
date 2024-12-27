package school.faang.sprint4.task50100;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint4.task50100.model.Order;
import school.faang.sprint4.task50100.model.OrderStatus;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int TIME_TO_PROCESS = 1000;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> results = orders.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(results.toArray(new CompletableFuture[results.size()])).join();
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }

    @SuppressWarnings("checkstyle:WhitespaceAround")
    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            if (order.getStatus() == OrderStatus.NEW) {
                order.setStatus(OrderStatus.IN_PROGRESS);
                try {
                    Thread.sleep(TIME_TO_PROCESS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
                log.info("Order {} was processed in {} sec", order.getId(), TIME_TO_PROCESS / 1000.);
            }
        });
    }
}
