package school.faang.sprint4.bjs_50040;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {

    public void processAllOrders(List<Order> orders) {
        AtomicInteger totalOrders = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> futures.forEach(future -> totalOrders.incrementAndGet()))
                .join();

        log.info("Total order processed : {}", totalOrders.get());
    }

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Processing order number {}", order.getIdOrder());
                Thread.sleep(1000);
                order.setStatus(OrderStatus.PROCESSED);
                log.info("Order number {} done", order.getIdOrder());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                order.setStatus(OrderStatus.CANCELED);
                log.info("Order number {} canceled", order.getIdOrder());
            }
        });
    }
}
