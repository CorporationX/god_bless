package faang.school.godbless.deliverycoupons;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 3;

    public static void main(String[] args) {
        DeliveryService service = new DeliveryService();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        service.addPromoCode(new PromoCode("PROMO10", 10.0,
                LocalDate.of(2024, 12, 31), 50.0));
        service.addPromoCode(new PromoCode("PROMO20", 20.0,
                LocalDate.of(2024, 12, 31), 100.0));
        service.addPromoCode(new PromoCode("PROMO30", 30.0,
                LocalDate.of(2024, 12, 31), 150.0));

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                Order order = new Order();
                order.addProduct(new Product("Burger", 60.0));
                order.addProduct(new Product("Fries", 30.0));
                order.addProduct(new Product("Cola", 20.0));
                List<String> promoCodes = List.of("PROMO10", "PROMO20", "PROMO30");
                service.processOrder(order, promoCodes);
                log.info("Order total after discount: {}", order.getTotalPrice());
            });
        }
        shutdown(executor);
        service.printProcessedOrders();
    }

    private static void shutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
    }
}