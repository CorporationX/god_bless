package school.faang.bjs2_93200;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderProcessor {
    private static final int NUM_THREADS = 5;
    private static final int TIMEOUT_IN_SECONDS = 60;
    private static final int LOWER_BOUND = 1500;
    private static final int UPPER_BOUND = 5000;

    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
    private Random randomTime = new Random();

    public CompletableFuture<Order> processOrder(Order order) {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (order) {
                log.info("Изменение статуса заказа #{}", order.getId());
                try {
                    Thread.sleep(randomTime.nextInt(LOWER_BOUND, UPPER_BOUND));
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
                OrderStatus[] orderStatuses = OrderStatus.values();

                int oldOrderStatus = order.getStatus().ordinal();
                if (!order.getStatus().equals(OrderStatus.DONE)) {
                    order.setStatus(orderStatuses[oldOrderStatus + 1]);
                    log.info("Заказ #{} изменил статус: {} -> {}",
                            order.getId(), orderStatuses[oldOrderStatus], order.getStatus());
                } else {
                    log.info("Заказ #{} имеет статус {}", order.getId(), order.getStatus());
                }
                if (order.getStatus().equals(OrderStatus.CONFIRMED)) {
                    totalProcessedOrders.addAndGet(1);
                }
            }
            return order;
        }, executorService);
    }

    public void getTotalProcessedOrders() {
        log.info("Обработано {} заказ(-а,-ов)", totalProcessedOrders);
    }

    public void shutdownCorrectly() {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)) {
                log.info("Все заказы обработаны");
            } else {
                log.info("Не все заказы успели обработаться");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());

        }
    }
}
