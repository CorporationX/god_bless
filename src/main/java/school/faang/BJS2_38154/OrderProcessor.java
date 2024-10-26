package school.faang.BJS2_38154;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static final int THREAD_NUMBERS = 5;
    private static final Logger logger = LoggerFactory.getLogger(OrderProcessor.class);
    ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBERS);
    private AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        this.totalProcessedOrders = new AtomicInteger(0);
    }

    public CompletableFuture<Order> processOrder(Order order) {
        CompletableFuture<Order> futureOrder = CompletableFuture.supplyAsync(() -> {
            try {
                logger.info("Обработка заказа {}", order.getId());
                Thread.sleep(10_000);
                order.setStatus(OrderStatus.PROCESSED);
            } catch (Exception e) {
                logger.error("Ошибка при обработке заказа", e);
                Thread.currentThread().interrupt();
            }
            return order;
        }, executor);
        return futureOrder;
    }

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> futureOrders = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                futureOrders.toArray(new CompletableFuture[0])
        );

        allTasks.thenRun(() -> {
            futureOrders.forEach(futureOrder -> totalProcessedOrders.incrementAndGet());
            System.out.println("Общее количество заказов: " + totalProcessedOrders.get());
        }).join();
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.isShutdown()) {
                logger.info("Потоки не завершились самостоятельно");
                executor.awaitTermination(40, TimeUnit.SECONDS);
                executor.shutdownNow();
            }
        } catch (Exception e) {
            logger.error("Ошибка при завершении пула потоков", e);
        }
    }
}
