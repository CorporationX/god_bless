package ru.kraiush.BJS2_38082;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        this.totalProcessedOrders = new AtomicInteger(0);
    }

    public CompletableFuture<Integer> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(5_000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    order.setStatus("Processed");
                    return totalProcessedOrders.incrementAndGet();
                }
        );
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Integer>> orderFutures = orders.stream()
                .map(order -> processOrder(order))
                .toList();
        CompletableFuture.allOf(orderFutures.toArray(new CompletableFuture[0])).join();
        System.out.println("Quantity of processed orders: " + totalProcessedOrders.get());
    }
}
