package school.faang.sprint_4.task_51094;

import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        PromoCode promo1 = new PromoCode("DISCOUNT10", 10, LocalDate.now().plusDays(1), BigDecimal.valueOf(100), false);
        PromoCode promo2 = new PromoCode("BIGSALE20", 20, LocalDate.now().plusDays(1), BigDecimal.valueOf(150), false);
        PromoCode promo3 = new PromoCode("BIGSALE40", 40, LocalDate.now().plusDays(1), BigDecimal.valueOf(150), false);

        deliveryService.addPromoCode(promo1);
        deliveryService.addPromoCode(promo2);
        deliveryService.addPromoCode(promo3);

        Order order1 = new Order(List.of(
                new Product("Burger", BigDecimal.valueOf(120)),
                new Product("Fries", BigDecimal.valueOf(50))
        ));

        Order order2 = new Order(List.of(
                new Product("Burger", BigDecimal.valueOf(120)),
                new Product("Fries", BigDecimal.valueOf(50))
        ));

        Order order3 = new Order(List.of(
                new Product("Burger", BigDecimal.valueOf(120)),
                new Product("Fries", BigDecimal.valueOf(50))
        ));

        Set<String> promoCodes = Set.of("DISCOUNT10", "BIGSALE20", "BIGSALE40");

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            try {
                deliveryService.processOrder(order1, promoCodes);
            } catch (OrderException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.submit(() -> {
            try {
                deliveryService.processOrder(order2, promoCodes);
            } catch (OrderException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.submit(() -> {
            try {
                deliveryService.processOrder(order3, promoCodes);
            } catch (OrderException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Order 1 total price: " + order1.getTotalPrice());
        System.out.println("Order 2 total price: " + order2.getTotalPrice());
        System.out.println("Order 3 total price: " + order3.getTotalPrice());
    }
}
