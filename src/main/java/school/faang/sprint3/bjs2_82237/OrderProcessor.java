package school.faang.sprint3.bjs2_82237;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    public static final int THREAD_POOL_BATCH = 5;

    private static final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService executorService;

    public OrderProcessor(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public List<CompletableFuture<Void>> processAllOrders(List<Order> orders) {
        return orders.stream().map(this::processOrder).toList();
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                order.setStatus(OrderStatus.PROCEED);
                totalProcessedOrders.incrementAndGet();
                return null;
            } catch (InterruptedException e) {
                order.setStatus(OrderStatus.ERROR);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }, executorService);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_BATCH);
        OrderProcessor processor = new OrderProcessor(executorService);

        // Создание списка заказов
        List<Order> orders = List.of(
                new Order(),
                new Order(),
                new Order()
        );

        // Обработка заказов
        List<CompletableFuture<Void>> operations = processor.processAllOrders(orders);
        CompletableFuture.allOf(operations.toArray(new CompletableFuture[0])).join();

        System.out.println("Обработанное количество заказов: " + totalProcessedOrders.get());

        System.out.println(orders);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
