package school.faang.collect_order_amazon;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    private void plusTotalOrders() {
        totalProcessedOrders.incrementAndGet();
    }

    public AtomicInteger processOrder(List<Order> orders) {
        Random random = new Random();
        final int fixedThread = 3;
        ExecutorService service = Executors.newFixedThreadPool(fixedThread);
        List<CompletableFuture<Order>> completableFutureList = new ArrayList<>();

        for (Order order : orders) {
            CompletableFuture<Order> completableFuture = CompletableFuture.supplyAsync(() -> {
                log.info("Отправка заказа {} началась", order.getId());

                try {
                    Thread.sleep(random.nextLong(10000) + 100);
                    order.setStatus(true);
                    plusTotalOrders();
                    log.info("Заказ {} отправился", order.getId());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Error!!!!!!!!!!!!!!!!!!");
                }

                return order;
            }, service);
            completableFutureList.add(completableFuture);
        }

        for (CompletableFuture<Order> completableFuture : completableFutureList) {
            completableFuture.join();
        }

        service.shutdown();
        return totalProcessedOrders;
    }
}
