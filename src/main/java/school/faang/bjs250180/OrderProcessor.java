package school.faang.bjs250180;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {

    private static final int TWO_SECONDS = 2000;
    private static final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TWO_SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread interrupted while processing order: {}", order);
            }
            order.setStatus("Обработано");
            log.info("Order processed: {}", order);
            return order;
        });
    }

    public Integer processAllOrders(List<Order> orders) {

        List<CompletableFuture<Order>> orderFutures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(orderFutures.toArray(new CompletableFuture[0]));

        allFutures.join();

        orderFutures.forEach(order -> {
            if (order.isDone()) {
                totalProcessedOrders.incrementAndGet();
            }
        });

        return totalProcessedOrders.get();
    }
}
