package school.faang.bjs275494;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final ExecutorService executorService = Executors.newFixedThreadPool(3);
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                order.setStatus("Обработано");
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Ошибка");
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
