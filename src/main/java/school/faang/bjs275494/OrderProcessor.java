package school.faang.bjs275494;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final ExecutorService executorService = Executors.newFixedThreadPool(3);
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int DELAY = 1000;

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(DELAY);
                order.setStatus(OrderStatus.PROCESSED);
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                order.setStatus(OrderStatus.FAILED);
                System.out.println("Ошибка при обработке заказа #" + order.getId());
            }
        }, executorService);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Обработано заказов: " + totalProcessedOrders.get());
        executorService.shutdown();
    }
}
