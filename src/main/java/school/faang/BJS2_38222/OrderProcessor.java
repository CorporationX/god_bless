package school.faang.BJS2_38222;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                order.setStatus("Обработанно");
                totalProcessedOrders.incrementAndGet();
                System.out.println("Заказ №" + order.getId() + " обработан");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Произошла ошибка при обработке заказа №" + order.getId());
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        CompletableFuture<?>[] futures = orders.stream()
            .map(this::processOrder)
            .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();
        System.out.println("Все заказы обработаны: " + totalProcessedOrders.get());
    }
}
