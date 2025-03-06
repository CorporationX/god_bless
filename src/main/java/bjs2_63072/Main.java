package bjs2_63072;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int THREADS_COUNT = 10;
    public static final int WAITING_TERMINATION_TIMEOUT_SECOND = 3;
    public static final List<PromoCode> AVAILABLE_PROMO_CODES = List.of(
            new PromoCode("SPRING25", 25, LocalDateTime.now().plusDays(1), 500),
            new PromoCode("HAPPY50", 50, LocalDateTime.now().minusDays(1), 20),
            new PromoCode("CHERY7", 7, LocalDateTime.now().plusDays(1), 5),
            new PromoCode("AUDI80", 80, LocalDateTime.now().plusDays(1), 7)
    );
    public static final List<String> USER_PROMO_CODES = List.of(
            "START15",
            "LOSS100",
            "SPRING25",
            "HAPPY50",
            "CHERY7",
            "AUDI80");
    public static final List<Product> PRODUCTS = List.of(
            new Product("Молоко", 100),
            new Product("Хлеб", 50),
            new Product("Кефир", 80),
            new Product("Яблоки", 200),
            new Product("Помидоры", 300),
            new Product("Перец", 300),
            new Product("Сыр", 1000),
            new Product("Гречка", 100),
            new Product("Печеньки", 150),
            new Product("Шоколадка", 150)
    );

    public static void main(String[] args) {
        var deliveryService = new DeliveryService();

        for (var promoCode : AVAILABLE_PROMO_CODES) {
            deliveryService.addPromoCode(promoCode);
        }

        var executor = Executors.newFixedThreadPool(THREADS_COUNT);
        createAndProcessOrder(
                executor,
                deliveryService,
                List.of(PRODUCTS.get(0), PRODUCTS.get(1), PRODUCTS.get(3)));
        createAndProcessOrder(
                executor,
                deliveryService,
                List.of(PRODUCTS.get(5), PRODUCTS.get(6), PRODUCTS.get(7)));
        createAndProcessOrder(
                executor,
                deliveryService,
                List.of(PRODUCTS.get(2), PRODUCTS.get(8), PRODUCTS.get(9)));
        createAndProcessOrder(
                executor,
                deliveryService,
                List.of(PRODUCTS.get(3), PRODUCTS.get(4), PRODUCTS.get(5)));
        createAndProcessOrder(
                executor,
                deliveryService,
                List.of(PRODUCTS.get(3), PRODUCTS.get(5), PRODUCTS.get(7)));
        executor.shutdown();

        try {
            if (!executor.awaitTermination(WAITING_TERMINATION_TIMEOUT_SECOND, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.error("Потоки не завершились за заданное время");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            log.error("Ошибка при завершении потоков: {}", e.getMessage(), e);
        }

        deliveryService.showProcessedOrders();
    }

    private static void createAndProcessOrder(
            ExecutorService executor,
            DeliveryService deliveryService,
            List<Product> products) {
        executor.execute(() -> {
            var order = new Order(products);
            deliveryService.processOrder(order, USER_PROMO_CODES);
        });
    }
}
