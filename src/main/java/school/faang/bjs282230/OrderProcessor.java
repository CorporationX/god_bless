package school.faang.bjs282230;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Slf4j
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Начинаем обработку заказа {}", order.getId());
                Thread.sleep(1000);

                order.setStatus("Обработано");

                totalProcessedOrders.incrementAndGet();

                log.info("Заказ {} обработан успешно", order.getId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Обработка заказа {} была прервана", order.getId(), e);
            }
        });
    }

    public void processAllOrders(List<Order> orders) {
        log.info("Начинаем обработку {} заказов", orders.size());

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(this::processOrder)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("Все заказы обработаны. Общее количество: {}", totalProcessedOrders.get());
    }
}
