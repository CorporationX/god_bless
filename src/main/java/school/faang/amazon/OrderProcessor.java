package school.faang.amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static final int MILLIS = 1000;
    private final AtomicInteger totalProcessedOrders = new AtomicInteger();
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(MILLIS);
                order.setStatus("обработано");
                int currentCount = totalProcessedOrders.incrementAndGet();
                System.out.println("Заказ " + order.getId() + " обработан. Текущий счётчик: " + currentCount);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, executor);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        all.thenRun(() -> {
            System.out.println("✅ Все заказы обработаны. Общее количество: " + totalProcessedOrders.get());
            executor.shutdown();
        });

        try {
            all.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
