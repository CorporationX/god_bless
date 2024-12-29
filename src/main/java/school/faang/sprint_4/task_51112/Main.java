package school.faang.sprint_4.task_51112;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();
        addPromoCodes(deliveryService);
        List<Order> orders = getCreatedOrders();
        ExecutorService executor = Executors.newFixedThreadPool(orders.size());

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        orders.forEach(order -> {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                deliveryService.processOrder(order);
            });
            futures.add(future);
        });

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .whenComplete((result, throwable) -> {
                    if (throwable == null) {
                        log.info("Все заказы обработаны");
                        executor.shutdown();
                    } else {
                        log.error("Произошла ошибка при выполнении задачи: {}", throwable.getMessage());
                    }
                })
                .join();
    }

    private static void addPromoCodes(DeliveryService deliveryService) {
        List<PromoCode> promoCodes = List.of(
                new PromoCode(
                        "PROMO10",
                        10,
                        LocalDateTime.of(2024, 12, 31, 23, 59, 59),
                        500),

                new PromoCode(
                        "PROMO20",
                        20,
                        LocalDateTime.of(2024, 12, 31, 23, 59, 59),
                        1000),

                new PromoCode(
                        "PROMO30",
                        30,
                        LocalDateTime.of(2023, 12, 31, 23, 59, 59),
                        1500)
        );
        promoCodes.forEach(deliveryService::addPromoCode);
    }

    private static List<Order> getCreatedOrders() {
        List<Product> products = Arrays.asList(
                new Product("Товар 1", 1200),
                new Product("Товар 2", 500),
                new Product("Товар 3", 750)
        );

        return Arrays.asList(
                new Order(Arrays.asList(products.get(0), products.get(1))),
                new Order(Arrays.asList(products.get(1), products.get(2))),
                new Order(Arrays.asList(products.get(0), products.get(2)))
        );
    }

}
