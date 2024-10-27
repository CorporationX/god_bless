package school.faang.bjs2_38143;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processAllOrder(List<Order> orders) {
        List<CompletableFuture<Order>> futuresOrdersList = orders.stream()
                .map(this::processOrder)
                .toList();

        for (CompletableFuture<Order> order : futuresOrdersList) {
            order.join();
            CompletableFuture.allOf(order);

        }

        System.out.println("Number of orders processed: " + totalProcessedOrders.get());
    }

    private CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(2_000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return order;
                })
                .thenApply(orderFuture -> {
                    if (order.getStatus().equals(Order.Status.NEW)) {
                        log.info(String.format("Status order %d changed from %s to %s", order.getId(), order.getStatus(), Order.Status.PROCESSED.name()));
                        order.setStatus(Order.Status.PROCESSED);
                    } else {
                        log.warn(String.format("Oops.Order %s has already been processed", order.getId()));
                    }
                    totalProcessedOrders.addAndGet(1);

                    return orderFuture;
                });
    }
}
