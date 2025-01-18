package collect_amazon_orders;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(2);

        OrderProcessor orderProcessor = new OrderProcessor();

        CompletableFuture<Order> future1 = orderProcessor.processOrder(new Order("Ожидание", 1), executorService);
        CompletableFuture<Order> future2 = orderProcessor.processOrder(new Order("Ожидание", 2), executorService);

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2)
                .thenRun(() -> System.out.println("Все задачи выполнены! результат обработанных запросов: "
                        + orderProcessor.getTotalProcessedOrders()));
        combinedFuture.join();
        executorService.shutdown();
    }
}

