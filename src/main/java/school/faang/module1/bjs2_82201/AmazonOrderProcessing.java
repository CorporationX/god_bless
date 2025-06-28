package school.faang.module1.bjs2_82201;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static school.faang.module1.bjs2_82201.OrderStatus.NEW;

@Slf4j
public class AmazonOrderProcessing {

    private static final int POOL_SIZE = 4;
    private static final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
    private static final int TIMEOUT = 60;

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(NEW),
                new Order(NEW),
                new Order(NEW),
                new Order(NEW),
                new Order(NEW),
                new Order(NEW),
                new Order(NEW)
        );

        processor.processAllOrders(orders, executor);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Не все задачи завершились за указанное время. Принудительное завершение");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Главный поток был прерван", e);
            executor.shutdownNow();
        }
        log.info("Обработка всех заказов завершена");
    }
}