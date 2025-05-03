package school.faang.delivery.coupon;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final ExecutorService executor = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws InterruptedException {
        DeliveryService service = new DeliveryService();

        service.addPromoCode(PromoCode.builder()
                .code("10")
                .discount(10)
                .expirationDate(LocalDate.now().plusDays(7))
                .minimumOrderValue(500)
                .build());
        service.addPromoCode(PromoCode.builder()
                .code("15")
                .discount(15)
                .expirationDate(LocalDate.now().plusDays(3))
                .minimumOrderValue(1000)
                .build());
        service.addPromoCode(PromoCode.builder()
                .code("20")
                .discount(20)
                .expirationDate(LocalDate.now().plusDays(5))
                .minimumOrderValue(2000)
                .build());
        service.addPromoCode(PromoCode.builder()
                .code("50")
                .discount(60)
                .expirationDate(LocalDate.now().minusDays(1))
                .minimumOrderValue(5000)
                .build());

        List<Product> products1 = List.of(
                new Product("600", 600),
                new Product("300", 300)
        );

        List<Product> products2 = List.of(
                new Product("400", 400),
                new Product("200", 200),
                new Product("750", 750)
        );

        List<Product> products3 = List.of(
                new Product("2500", 2500),
                new Product("3000", 3000)
        );

        List<Product> products4 = List.of(
                new Product("200", 200),
                new Product("2000", 2000)
        );

        executor.execute(() -> {
            Order order = new Order(products1);
            service.processOrder(order, List.of("10", "15"));
            log.info("Order 1 final price: {}", order.getFinalPrice());
        });

        executor.execute(() -> {
            Order order = new Order(products2);
            service.processOrder(order, List.of("10", "15"));
            log.info("Order 2 final price: {}", order.getFinalPrice());
        });

        executor.execute(() -> {
            Order order = new Order(products3);
            service.processOrder(order, List.of("10", "15", "20", "50"));
            log.info("Order 3 final price: {}", order.getFinalPrice());
        });

        executor.execute(() -> {
            Order order = new Order(products4);
            service.processOrder(order, List.of("60", "15", "20", "50"));
            log.info("Order 4 final price: {}", order.getFinalPrice());
        });

        shutdown();

        service.getProcessedOrders().forEach(order ->
                log.info("Total price: {}, Final price: {}, Discount: {}",
                        order.getTotalPrice(),
                        order.getFinalPrice(),
                        order.getDiscount()));
    }

    private static void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
