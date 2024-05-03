package faang.school.godbless.delivery_coupons;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) throws InterruptedException {
        DeliveryService deliveryService = new DeliveryService();
        Promocode promocode1 = new Promocode("promocode1", 20, LocalDateTime.now().plusDays(20), 3000);
        Promocode promocode2 = new Promocode("promocode2", 10, LocalDateTime.now().plusDays(20), 1000);
        Promocode promocode3 = new Promocode("promocode3", 50, LocalDateTime.now().plusDays(20), 10000);
        List<String> promocodes = List.of(promocode1.getCode(), promocode2.getCode(), promocode3.getCode());
        deliveryService.addNewPromocode(promocode1);
        deliveryService.addNewPromocode(promocode2);
        deliveryService.addNewPromocode(promocode3);
        Order order1 = new Order(List.of(new Product("test", 3000)));
        Order order2 = new Order(List.of(new Product("test", 10000)));
        Order order3 = new Order(List.of(new Product("test", 2999)));
        Order order4 = new Order(List.of(new Product("test", 190)));
        List<Order> orders = List.of(order1, order2, order3, order4);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        CountDownLatch countDownLatch = new CountDownLatch(orders.size());

        orders.forEach(order ->
            executorService.execute(() -> {
                deliveryService.processOrder(order, promocodes);
                countDownLatch.countDown();
            })
        );

        countDownLatch.await();
        executorService.shutdown();
    }
}
