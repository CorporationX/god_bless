package school.faang.amazon_bjs2_93203;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    AtomicInteger totalProcessedOrders = new AtomicInteger();
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);

                order.setStatus(Status.PROCESSED);

                totalProcessedOrders.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " " + order + totalProcessedOrders.get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }, executorService);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> future = orders.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(future.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    System.out.println("Обработано заказов: " + totalProcessedOrders.get());
                })
                .join();
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new RuntimeException(e);
        }

    }
}
