package school.faang.asynchrony.amazon;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final static int THREAD_SLEEP_TIME = 1000;

    public void processOrder(Order order) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(THREAD_SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            order.setStatus(OrderStatus.PROCESSED);
            totalProcessedOrders.incrementAndGet();
        });
        future.join();
    }

    public void processAllOrders(List<Order> orders) {
        orders.forEach(this::processOrder);
        System.out.println("Total processed orders are : " + totalProcessedOrders);
    }


}
