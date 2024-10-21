package school.faang.collect_orders_from_amazon.main_code;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderProcessor {
    private static final int TIME_AWAIT = 2;
    private static final int TIME_SLEEP = 2000;
    private static final int THREAD_COUNT = 4;
    private AtomicInteger totalProcessedOrders = new AtomicInteger();

    public void processAllOrders(List<Order> orders) {
        List<CompletableFuture<Order>> futures = orders.stream()
                   .map(order -> processOrder(order))
                   .collect(Collectors.toList());


        CompletableFuture<Void> allOrders =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOrders.thenRun(() -> System.out.println("Обработано заказов " + totalProcessedOrders));

        allOrders.join();
    }

    private CompletableFuture<Order> processOrder(Order order) {
        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

        CompletableFuture<Order> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TIME_SLEEP);
            } catch (InterruptedException e) {
                throw new RuntimeException("ошибка при попытке обработать заказ" + e);
            }

            order.setStatus("Обработано");
            totalProcessedOrders.incrementAndGet();

            return order;
        }, service);

        service.shutdown();
        try {
            if (!service.awaitTermination(TIME_AWAIT, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Ошибка при попытке завершить программу");
            e.printStackTrace();
            service.shutdownNow();

        }

        return future;
    }
}
