package school.faang.amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders;
    public OrderProcessor() {
        this.totalProcessedOrders = new AtomicInteger(0);
    }
    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
                System.out.println("Заказ " + order.getId() + " обработан");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Обработано заказов: " + totalProcessedOrders.get());
    }
}