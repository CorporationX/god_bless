package school.faang.bjs250189;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final Random random = new Random();
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    private CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            int timeSpent = random.nextInt(5) + 1;
            try {
                TimeUnit.SECONDS.sleep(timeSpent);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus(Status.PROCESSED);
            totalProcessedOrders.incrementAndGet();
            System.out.printf("Order:  %s was processed after %s second\n", order.getId(), timeSpent);
        }, executorService);
    }

    public  void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Total processed orders: " + totalProcessedOrders.get());
        executorService.shutdown();
    }
}
