package school.faang.task_62130;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class OrderProcessor {
    private static final int LEAD_TIME = 5_000;
    private static final String START_PROCESS_MESSAGE = "Заказ № {} со статусом \"{}\" взят в обработку.";
    private static final String INTERRUPT_PROCESS_MESSAGE = "Обработка заказа № {} прервана.";
    private static final String END_PROCESS_MESSAGE
            = "Обработка заказа № {} завершена. Заказ переведён в статус \"{}\".";

    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Order> processOrder(@NonNull Order order) {
        return CompletableFuture.supplyAsync(() -> {
            int orderId = order.getId();
            log.info(START_PROCESS_MESSAGE, orderId, order.getStatus());
            try {
                Thread.sleep(LEAD_TIME);
                order.setStatus(OrderStatus.PROCESSED.getStatus());
                totalProcessedOrders.incrementAndGet();
                log.info(END_PROCESS_MESSAGE, orderId, order.getStatus());
            } catch (InterruptedException e) {
                log.error(INTERRUPT_PROCESS_MESSAGE, orderId);
                Thread.currentThread().interrupt();
                throw new RuntimeException("Возникла ошибка при обработке заказа", e);
            }
            return order;
        });
    }

    public List<CompletableFuture<Order>> processAllOrders(List<Order> orders) {
        return orders.stream()
                .map(this::processOrder)
                .toList();
    }
}
