package school.faang.BJS238131;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int THREADS = 2;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

    public void processOrder(Order order) {
        log.info("Обработка заказа, пожалуйста подождите");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            log.error("Проблема с обработкой заказа ", e);
        }
        int total = order.getId();
        totalProcessedOrders.addAndGet(total);
    }

    public void processAllOrders(List<Order> orders) {
       List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> CompletableFuture.runAsync(() -> processOrder(order), executorService))
                .collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Счетчик заказа увеличен " + totalProcessedOrders))
                .join();
    }

    public void shutDown() {
        executorService.shutdown();
    }
}
