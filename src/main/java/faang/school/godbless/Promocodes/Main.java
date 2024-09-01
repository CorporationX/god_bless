package faang.school.godbless.Promocodes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        deliveryService.add(new PromoCode("promo1", 10, 100, LocalDateTime.of(2030,1,1,1,1,1), false));
        deliveryService.add(new PromoCode("promo2", 5, 50, LocalDateTime.of(2030,1,1,1,1,1), false));

        List<Order> orders = new ArrayList<>();
        Order order1 = new Order();
        order1.addProduct(new Product("skin", 110));
        orders.add(order1);
        Order order2 = new Order();
        order2.addProduct(new Product("abra", 55));
        orders.add(order2);
        Order order3 = new Order();
        order3.addProduct(new Product("vaba", 40));
        orders.add(order3);

        for (Order order : orders) {
            executorService.execute(() -> {
                deliveryService.processOrder(order, List.of("promo1", "promo2", "promo3"));
            });
        }

        executorService.shutdown();
    }
}
