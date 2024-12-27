package school.faang.task_50072;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static final long TIME_SLEEP = 1000;
    private static AtomicInteger totalProcessedOrders = new AtomicInteger();

    private void addTotalProcessedOrders() {
        totalProcessedOrders.incrementAndGet();
    }

    private CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(String.format("Begin of processing order %d, status %s...",
                        order.getId(), order.getStatus()));
                Thread.sleep(TIME_SLEEP * order.getId());
                order.setStatus(Status.PROCESSED.getTitle().toString());
                addTotalProcessedOrders();
                System.out.println(String.format("End of processing order %d, status %s.",
                        order.getId(), order.getStatus()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return order;
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> futureList = new ArrayList<>();
        orders.stream().map(order -> processOrder(order)).forEach(future -> futureList.add(future));
        futureList.forEach(future -> future.join());
        System.out.println(String.format("Total amount of processed orders: %d", totalProcessedOrders.get()));
    }
}