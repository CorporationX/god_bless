package school.faang.packing_orders_in_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int ORDER_PROCESS_TIME = 3000;

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> orderList = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture
                .allOf(orderList.toArray(new CompletableFuture[0]))
                .join();

        log.info("Total processed orders: {}", totalProcessedOrders.get());
    }

    private CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ORDER_PROCESS_TIME);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
                log.info("Order with id: {} was processed.", order.getId());
            } catch (InterruptedException e) {
                log.info("Order processing was interrupted for order with id: {}",
                        order.getId());
                Thread.currentThread().interrupt();
            }
            return order;
        });
    }
}