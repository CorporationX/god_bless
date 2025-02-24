package fooddelivery;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DeliveryServiceMain {

    private static final PromoCode PROMO10 = new PromoCode(
            "PROMO10",
            10,
            LocalDateTime.now().plusDays(1),
            50
    );
    private static final PromoCode PROMO20 = new PromoCode(
            "PROMO20",
            20,
            LocalDateTime.now().plusDays(1),
            100
    );
    private static final PromoCode PROMO15 = new PromoCode(
            "PROMO15",
            15,
            LocalDateTime.now().plusDays(1),
            75
    );

    private static final String CODE_PROMO10 = PROMO10.getCode();
    private static final String CODE_PROMO20 = PROMO20.getCode();
    private static final String CODE_PROMO15 = PROMO15.getCode();

    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        deliveryService.addPromoCode(PROMO10);
        deliveryService.addPromoCode(PROMO20);
        deliveryService.addPromoCode(PROMO15);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Runnable orderTask1 = () -> {
            Order order = new Order(List.of(
                    new Product("Burger", 30),
                    new Product("Fries", 25)
            ));
            deliveryService.processOrder(order, List.of(CODE_PROMO10, CODE_PROMO20));
        };

        Runnable orderTask2 = () -> {
            Order order = new Order(List.of(
                    new Product("Pizza", 90),
                    new Product("Soda", 15)
            ));
            deliveryService.processOrder(order, List.of(CODE_PROMO10, CODE_PROMO20, CODE_PROMO15));
        };

        Runnable orderTask3 = () -> {
            Order order = new Order(List.of(
                    new Product("Salad", 40),
                    new Product("Juice", 20)
            ));
            deliveryService.processOrder(order, List.of(CODE_PROMO15, CODE_PROMO10));
        };

        Runnable orderTask4 = () -> {
            Order order = new Order(List.of(
                    new Product("Steak", 120)
            ));
            deliveryService.processOrder(order, List.of(CODE_PROMO20));
        };

        Runnable orderTask5 = () -> {
            Order order = new Order(List.of(
                    new Product("Sushi", 80),
                    new Product("Tea", 10)
            ));
            deliveryService.processOrder(order, List.of(CODE_PROMO10, CODE_PROMO15));
        };

        List<Runnable> tasks = List.of(orderTask1, orderTask2, orderTask3, orderTask4, orderTask5);
        tasks.forEach(executor::submit);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.warn("Not all tasks finished in time, forcing shutdown");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted while waiting for tasks to finish", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        log.info("Processed orders: {}", deliveryService.getProcessedOrders());
    }
}
