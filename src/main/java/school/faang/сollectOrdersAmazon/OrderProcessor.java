package school.faang.сollectOrdersAmazon;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
public class OrderProcessor {
    final int THREADS = 5;
    private ExecutorService executor = Executors.newFixedThreadPool(THREADS);
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Integer> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                if (order.getOrderStatus() == "Новый") {
                    order.setOrderStatus("Обработано");
                    log.info("Обработка заказа...");
                    Thread.sleep(5000);
                    return 1;
                } else {
                    return 0;
                }
            } catch (InterruptedException e) {
                log.error("Подсчет заказа прерван.");
                throw new RuntimeException(e);
            }
        }, executor);
    }

    public void processAllOrders(List<Order> orders) throws InterruptedException {
        List<CompletableFuture<Integer>> futures = orders.stream().map(this::processOrder).toList();
        futures.forEach(future -> totalProcessedOrders.addAndGet(future.join()));
        System.out.println("Обработано заказов: " + totalProcessedOrders.get());
        executor.shutdown();
        executor.awaitTermination(20, TimeUnit.SECONDS);
    }
}
