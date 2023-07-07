package faang.school.godbless.amazon;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class OrderProcessor {
    public static AtomicInteger totalProcessedOrders = new AtomicInteger();
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public CompletableFuture<Order> processOrder(Order order) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.addAndGet(1);

            return order;
        }, executorService);
    }
}
