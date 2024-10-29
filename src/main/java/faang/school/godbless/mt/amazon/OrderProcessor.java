package faang.school.godbless.mt.amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final static long PROCESS_TIME = 10000;
    private final AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        this.totalProcessedOrders = new AtomicInteger(0);
    }

    public List<CompletableFuture<Order>> processOrders(List<Order> orders) {
        return orders.stream().map(this::processOrder).toList();
    }

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Order processing started. Order id = {}", order.getId());
            order.setStatus(Order.Status.PROCESS);
            try {
                Thread.sleep(PROCESS_TIME);
            } catch (InterruptedException e) {
                log.warn("Interrupted. Canceled processing order. Order id = {}", order.getId());
                order.setStatus(Order.Status.CANCELED);
                return order;
            }
            order.setStatus(Order.Status.COMPLETED);
            int currentProcessedOrders = totalProcessedOrders.incrementAndGet();
            log.info("Order completed. Order id = {}. {} orders were processed", order.getId(), currentProcessedOrders);
            return order;
        });
    }

    public int getProcessedOrdersCount() {
        return totalProcessedOrders.get();
    }

}
