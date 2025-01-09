package school.faang.task_50209;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public void processAllOrders(List<Order> orders) {
        // Список для хранения CompletableFuture задач
        CompletableFuture<?>[] futures = orders.stream()
                .map(this::processOrder)
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();

        System.out.println("Обработано заказов: " + totalProcessedOrders.get());
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Ошибка при обработке заказа: " + order.getId());
            }
        });
    }
}

