package school.faang.bjs274672;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int WAITING_TIME = 5_000;
    private static final int THREAD_COUNT = 2;
    private static final int SHUTDOWN_TIME = 10;

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1),
                new Order(2),
                new Order(3)
        );

        processor.processAllOrders(orders);
        processor.shutdown();
    }

    private void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Void>> orderProcessResults = orders.stream()
                .map(this::processOrder)
                .toList();
        CompletableFuture.allOf(orderProcessResults.toArray(new CompletableFuture[0])).join();
        log.info("Processed orders: {}", this.getProcessedOrdersCount());
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Order [{}] processing is started.", order.getId());
                Thread.sleep(WAITING_TIME);
                order.setStatus(Status.DONE);
                totalProcessedOrders.incrementAndGet();
                log.info("Order [{}] processed success.", order.getId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Processing for order [{}] interrupted: {}", order.getId(), e.getMessage());
                throw new RuntimeException(e);
            }
        }, threadPool);
    }

    public int getProcessedOrdersCount() {
        return totalProcessedOrders.get();
    }

    public void shutdown() {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(SHUTDOWN_TIME, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted: {}", e.getMessage());
        }
    }
}
