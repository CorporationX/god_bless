package faang.school.godbless.collectingOrdersOnAmazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, Status.progress));
        orders.add(new Order(2, Status.progress));
        orders.add(new Order(3, Status.processed));
        orders.add(new Order(4, Status.progress));
        orders.add(new Order(5, Status.progress));

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (Order order : orders) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                orderProcessor.processOrder(order);
            }, executor);
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    System.out.println("Обработано заказов: " + orderProcessor.getTotalProcessedOrders());
                    executor.shutdown();
                    try {
                        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                            executor.shutdownNow();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).join();
    }
}
