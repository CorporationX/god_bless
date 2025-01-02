package school.faang.sprint_4.task_50090;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderProcessor {
    private static AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .collect(Collectors.toList());
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        System.out.println("Обработано заказов: " + totalProcessedOrders.get());
    }
}
