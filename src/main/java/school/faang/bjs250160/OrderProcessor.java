package school.faang.bjs250160;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private List<CompletableFuture<Void>> futures = new ArrayList<>();

    public void processOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order can not be null");
        }
        futures.add(CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
                order.setOrderStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted");
            }
        }));
    }

    public void totalProcess() {
        CompletableFuture<Void> orders = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        orders.thenRun(() -> System.out.println("All orders processing: " + totalProcessedOrders.get()));
        try {
            orders.get(20, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Error waiting processed orders");
            e.getMessage();
        }
    }
}
