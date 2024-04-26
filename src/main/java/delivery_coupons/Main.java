package delivery_coupons;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final ExecutorService SERVICE = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();
        List<PromoCode> promoCodes = new ArrayList<>();
        PromoCode promoCode1 = new PromoCode("SUMMER", 5, 2024, 40);
        promoCodes.add(promoCode1);
        PromoCode promoCode2 = new PromoCode("WINTER", 10, 2024, 50);
        promoCodes.add(promoCode2);
        PromoCode promoCode3 = new PromoCode("AUTUMN", 15, 2024, 90);
        promoCodes.add(promoCode3);
        PromoCode promoCode4 = new PromoCode("SPRING", 30, 2024, 120);
        promoCodes.add(promoCode4);
        deliveryService.addPromoCodes(promoCodes);

        for (int i = 0; i < 10; i++) {
            SERVICE.execute(() -> {
                Order order = new Order();
                for (int j = 0; j < ThreadLocalRandom.current().nextInt(5, 10); j++) {
                    order.addProduct(new Product("Product" + j, ThreadLocalRandom.current().nextDouble(10, 100)));
                }
                deliveryService.processOrder(order);
            });
        }
        SERVICE.shutdown();
        try {
            SERVICE.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("===Обработанные заказы===");
        deliveryService.getProcessedOrders().entrySet()
                .forEach(entry -> {
                    System.out.println("Order: " + entry.getKey());
                    System.out.println("Promo: " + entry.getValue());
                    System.out.println("=====================\n");
                });
    }
}
