package school.faang.ordersamazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.processAllOrders(List.of(new Order(1), new Order(2), new Order(3)));
    }

    public CompletableFuture<Boolean> processOrder(Order order, ExecutorService service) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException("В методе processOrder ошибка", e);
            }
            order.setStatus("Обработано");
            System.out.println(totalProcessedOrders.incrementAndGet());
            return true;
        }, service);
    }

    private void processAllOrders(List<Order> allOrders) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        List<CompletableFuture<Boolean>> resultFutures = allOrders.stream()
                .map(order -> processOrder(order, service))
                .toList();
        CompletableFuture<Void> allOF = CompletableFuture.allOf(resultFutures.toArray(new CompletableFuture[0]));
        allOF.thenApply(v -> resultFutures.stream()
                .allMatch(CompletableFuture::join));
        service.awaitTermination(2, TimeUnit.SECONDS);
        service.shutdown();
        System.out.println(totalProcessedOrders.get());
    }
}