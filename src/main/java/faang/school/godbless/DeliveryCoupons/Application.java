package faang.school.godbless.DeliveryCoupons;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        PromoCode promoCode1 = new PromoCode("code1", 10, 500);
        PromoCode promoCode2 = new PromoCode("code2", 20, 600);
        PromoCode promoCode3 = new PromoCode("code3", 30, 700);
        PromoCode promoCode4 = new PromoCode("code4", 40, 800);
        PromoCode promoCode5 = new PromoCode("code5", 50, 900);
        DeliveryService deliveryService = new DeliveryService(List.of(
                promoCode1, promoCode2, promoCode3, promoCode4, promoCode5));

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                List<String> promoCodes = new ArrayList<>();
                promoCodes.add("code1");
                promoCodes.add("code2");
                promoCodes.add("code3");
                promoCodes.add("code4");
                promoCodes.add("code5");
                List<String> randomPromo = promoCodes.subList(0, ThreadLocalRandom.current().nextInt(1, 5));

                List<Product> products = new ArrayList<>();
                products.add(new Product("Product 1", 500));
                products.add(new Product("Product 2", 200));
                Order order = new Order(products);

                deliveryService.processOrder(order, randomPromo);
            });
        }

        executor.shutdown();
    }
}
