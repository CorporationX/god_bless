package faang.school.godbless.delivery;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    private static final ExecutorService SERVICE = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        DeliveryService deliveryService = new DeliveryService();
        PromoCode promoCode1 = new PromoCode("SUMMER", 5, LocalDateTime.of(2024, 3, 27, 15, 0), 40);
        deliveryService.addActivePromoCode(promoCode1);
        PromoCode promoCode2 = new PromoCode("WINTER", 10, LocalDateTime.of(2024, 5, 27, 15, 0), 50);
        deliveryService.addActivePromoCode(promoCode2);
        PromoCode promoCode3 = new PromoCode("AUTUMN", 15, LocalDateTime.of(2025, 5, 27, 15, 0), 90);
        deliveryService.addActivePromoCode(promoCode3);
        PromoCode promoCode4 = new PromoCode("SPRING", 20, LocalDateTime.of(2026, 5, 27, 15, 0), 120);
        deliveryService.addActivePromoCode(promoCode4);


        IntStream.rangeClosed(0, 10).forEach((i) -> {
            SERVICE.execute(() -> {
                Order order = new Order();
                for (int j = 0; j < ThreadLocalRandom.current().nextInt(1, 4); j++) {
                    order.addProduct(new Product("Product" + j, ThreadLocalRandom.current().nextDouble(10, 100)));
                }
                deliveryService.processOrder(order, List.of("SUMMER", "WINTER", "SPRING", "AUTUMN"));
            });
        });

        SERVICE.shutdown();
        try {
            SERVICE.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Processed orders");
        deliveryService.getProcessedOrders()
                .forEach(order -> {
                    System.out.println("Promo: " + order + "\n");
                });
    }
}
