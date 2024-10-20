package school.faang.ordersinamazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static final int TIME_TO_WORK = 1_000;

    private AtomicInteger totalProcessedOrders = new AtomicInteger();

    public void processOrder(Order order) {
        try {
            Thread.sleep(TIME_TO_WORK);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        order.setStatus(OrderStatus.PROCESSED);
        totalProcessedOrders.incrementAndGet();
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (Order order : orders) {
            futures.add(CompletableFuture.runAsync(() -> processOrder(order)));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Обработано заказов: " + totalProcessedOrders.get());
    }
}
