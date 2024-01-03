package faang.school.godbless.amazon_order;

import lombok.Data;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Data
public class Order {
    private final int id;

    private String status;

    public Order(int id) {
        this.id = id;
        this.status = "New";
    }
}

@Data
class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Работает поток: " + Thread.currentThread().getName());
                totalProcessedOrders.incrementAndGet();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Обработка заказов прервана: ", e);
            }
        }, executorService);
    }

    public int getTotalOrder() {
        return totalProcessedOrders.get();
    }

    public void stopExecutorService() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        List<CompletableFuture<Void>> futures = IntStream.rangeClosed(1, 1400)
                .mapToObj(Order::new)
                .map(orderProcessor::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        orderProcessor.stopExecutorService();

        System.out.println("Обработано " + orderProcessor.getTotalOrder() + " заказов.");
    }
}