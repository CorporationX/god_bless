package school.faang.bjs2_94849;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static final int THREAD_COUNT = 5;
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                order.setStatus("Processed");
                System.out.printf("Order %s processed\n", order.getId());
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted");
                Thread.currentThread().interrupt();
            }
        }, executorService);
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        System.out.printf("Processed %d orders\n", totalProcessedOrders.get());
    }

    public void shutdownExecutorSevice() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1000, TimeUnit.SECONDS)) {
                System.out.println("Can't stop executorService");
                executorService.shutdownNow();
                if (!executorService.awaitTermination(1000, TimeUnit.SECONDS)) {
                    System.out.println("Can't stop executorService even with shutdownNow()");
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
