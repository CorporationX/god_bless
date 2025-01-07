package school.faang.task_50142;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class OrderProcessor {

    private static AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private final List<CompletableFuture<Void>> futures = new ArrayList<>();

    public void processOrder(Order order) {
        CompletableFuture<Void> completableFuture =
                CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(10_000);
                        order.setStatusOrder(StatusOrder.FINISHED);
                        totalProcessedOrders.incrementAndGet();

                    } catch (InterruptedException e) {
                        log.error("Ошибка подсчета заказов" + e);
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                });

        futures.add(completableFuture);

    }

    public void totalOrders() {
        CompletableFuture<Void> allOrders =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOrders.thenRun(() -> {
            System.out.println("Все заказы обработаны: " + totalProcessedOrders.get());
        });

        try {
            allOrders.get();
        } catch (Exception e) {
            log.error("Ошибка при ожидании завершения заказов: ", e);
        }
    }
}
