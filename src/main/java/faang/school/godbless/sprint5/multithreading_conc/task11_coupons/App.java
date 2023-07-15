package faang.school.godbless.sprint5.multithreading_conc.task11_coupons;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        PromoCode promoCode1 = new PromoCode("Черная пятница", 0.3, LocalDateTime.now().plusDays(1), 100, false);
        PromoCode promoCode2 = new PromoCode("Скидка на одежду", 0.1, LocalDateTime.now().plusDays(7), 30, false);
        PromoCode promoCode3 = new PromoCode("Скидка на посуду", 0.2, LocalDateTime.now().plusDays(3), 30, false);
        PromoCode promoCode4 = new PromoCode("Скидка на бытовую технику", 0.2, LocalDateTime.now().plusDays(7), 200, false);

        deliveryService.addPromoCode(promoCode1);
        deliveryService.addPromoCode(promoCode2);
        deliveryService.addPromoCode(promoCode3);
        deliveryService.addPromoCode(promoCode4);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                Order order = new Order();
                for (int j = 0; j < 5; j++) {
                    order.addProduct(new Product());
                }
                deliveryService.processOrder(order);
            });
        }

        executor.shutdown();
    }
}
