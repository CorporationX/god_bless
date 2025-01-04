package school.faang.task_51123;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 3;
    private static final int TERMINATION_DELAY = 15;

    public static void main(String[] args) {
        DeliveryService deliveryService = setUpDeliveryService();
        Order order1 = setUpFirstOrder();
        Order order2 = setUpSecondOrder();
        Order order3 = setUpThirdOrder();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        executor.execute(() -> {
            deliveryService.processOrder(order1, List.of("CODE1"));
        });

        executor.execute(() -> {
            deliveryService.processOrder(order2, List.of("CODE2"));
        });

        executor.execute(() -> {
            deliveryService.processOrder(order3, List.of("CODE1"));
        });

        executor.shutdown();
        try {
            if (executor.awaitTermination(TERMINATION_DELAY, TimeUnit.SECONDS)) {
                log.info("First order total price: {}", order1.getTotalPrice());
                log.info("Second order total price: {}", order2.getTotalPrice());
                log.info("Third order total price: {}", order3.getTotalPrice());
                log.info("All tasks successfully completed");
            } else {
                log.info("Tasks are not completed");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    private static Order setUpThirdOrder() {
        Product product6 = new Product("Product6", 300);
        Product product7 = new Product("Product7", 500);
        Product product8 = new Product("Product8", 2000);
        Product product9 = new Product("Product9", 2000);
        Product product10 = new Product("Product10", 4000);

        Order order = new Order();

        order.addProduct(product6);
        order.addProduct(product7);
        order.addProduct(product8);
        order.addProduct(product9);
        order.addProduct(product10);

        return order;
    }

    private static Order setUpSecondOrder() {
        Product product4 = new Product("Product4", 1200);
        Product product5 = new Product("Product5", 500);

        Order order = new Order();

        order.addProduct(product4);
        order.addProduct(product5);

        return order;
    }

    private static Order setUpFirstOrder() {
        Product product1 = new Product("Product1", 300);
        Product product2 = new Product("Product2", 500);
        Product product3 = new Product("Product3", 1000);

        Order order = new Order();

        order.addProduct(product1);
        order.addProduct(product2);
        order.addProduct(product3);

        return order;
    }

    private static DeliveryService setUpDeliveryService() {
        PromoCode promoCode1 = new PromoCode(
                "CODE1",
                20,
                LocalDate.of(2025, 2, 13),
                1000);

        PromoCode promoCode2 = new PromoCode(
                "CODE2",
                15,
                LocalDate.of(2025, 1, 4),
                500);

        PromoCode promoCode3 = new PromoCode(
                "CODE3",
                10,
                LocalDate.of(2025, 3, 25),
                1300);

        DeliveryService deliveryService = new DeliveryService();

        deliveryService.addPromoCode(promoCode1);
        deliveryService.addPromoCode(promoCode2);
        deliveryService.addPromoCode(promoCode3);

        return deliveryService;
    }
}
