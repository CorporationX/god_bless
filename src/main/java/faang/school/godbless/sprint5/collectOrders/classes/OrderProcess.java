package faang.school.godbless.sprint5.collectOrders.classes;

import faang.school.godbless.sprint5.collectOrders.enums.Status;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcess {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            order.setStatus(Status.IN_PROGRESS);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus(Status.COMPLETED);
            totalProcessedOrders.addAndGet(1);
            return order;
        });
    }

    public int getTotalProcessedOrders(){
        return totalProcessedOrders.get();
    }
}
