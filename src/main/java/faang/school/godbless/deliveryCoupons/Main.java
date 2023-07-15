package faang.school.godbless.deliveryCoupons;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        PromoCode promoCode1 = new PromoCode();
        promoCode1.setCode("CODE1");
        promoCode1.setDiscount(0.1);
        promoCode1.setExpirationDate(Instant.parse("2023-12-31T23:59:59Z"));
        promoCode1.setMinimumOrderValue(50.0);
        deliveryService.addActivePromoCode(promoCode1);

        PromoCode promoCode2 = new PromoCode();
        promoCode2.setCode("CODE2");
        promoCode2.setDiscount(0.2);
        promoCode2.setExpirationDate(Instant.parse("2023-12-31T23:59:59Z"));
        promoCode2.setMinimumOrderValue(100.0);
        deliveryService.addActivePromoCode(promoCode2);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                List<Product> products = generateRandomProducts();
                Order order = new Order(products);

                List<PromoCode> availablePromoCodes = new ArrayList<>(deliveryService.getActivePromoCodes());
                Collections.shuffle(availablePromoCodes);

                if (!availablePromoCodes.isEmpty()) {
                    PromoCode bestPromoCode = availablePromoCodes.get(0);
                    List<String> promoCodes = List.of(bestPromoCode.getCode());
                    deliveryService.processOrder(order, promoCodes);
                } else {
                    deliveryService.processOrder(order, Collections.emptyList());
                }

            });
            thread.start();
        }
    }

    private static List<Product> generateRandomProducts() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Product product = new Product();
            product.setName("Product " + (i + 1));
            product.setPrice(ThreadLocalRandom.current().nextDouble(10, 100));
            products.add(product);
        }
        return products;
    }

}
