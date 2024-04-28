package faang.school.godbless.bjs2_6157;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        initPromoCodes().forEach(deliveryService::addActivePromoCode);

        List<String> promoCodes = List.of("D5", "D10", "D15", "D20", "D25");

        List<Order> orders = initOrders();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<CompletableFuture<Void>> futures = orders.stream()
                .map(order -> CompletableFuture.runAsync(() -> {
                    //Create random promo codes for order
                    int[] ids = new Random().ints(0, promoCodes.size())
                            .distinct()
                            .limit(new Random().nextInt(0, promoCodes.size())).toArray();

                    List<String> randomCodes = Arrays.stream(ids)
                            .mapToObj(promoCodes::get).toList();

                    deliveryService.processOrder(order, randomCodes);
                }, executorService)).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executorService.shutdown();

        deliveryService.printProcessedOrders();
    }

    public static List<Order> initOrders() {
        List<Order> orders = new ArrayList<>();
        Order order1 = new Order(1);
        order1.addProduct(new Product("Globus", 1000));
        order1.addProduct(new Product("Book", 500));

        Order order2 = new Order(2);
        order2.addProduct(new Product("Makita 3256", 3000));
        order2.addProduct(new Product("Spider Man Game", 5000));

        Order order3 = new Order(3);
        order3.addProduct(new Product("Accumulator", 10000));

        Order order4 = new Order(4);
        order4.addProduct(new Product("Monitor 20", 20000));
        order4.addProduct(new Product("Flashlight", 1500));

        Order order5 = new Order(5);
        order5.addProduct(new Product("SonyPS", 50000));
        order5.addProduct(new Product("Detroit", 3000));
        order5.addProduct(new Product("Omega 3", 3500));

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        return orders;
    }

    public static List<PromoCode> initPromoCodes() {
        List<PromoCode> codes = new ArrayList<>();

        PromoCode code5 = new PromoCode("D5", 5, LocalDateTime.of(2023, 5, 27, 15, 0), 1000);
        PromoCode code10 = new PromoCode("D10", 10, LocalDateTime.of(2024, 5, 27, 15, 0), 5000);
        PromoCode code15 = new PromoCode("D15", 15, LocalDateTime.of(2024, 5, 27, 15, 0), 10000);
        PromoCode code20 = new PromoCode("D20", 20, LocalDateTime.of(2024, 5, 27, 15, 0), 20000);
        PromoCode code25 = new PromoCode("D25", 25, LocalDateTime.of(2024, 5, 27, 15, 0), 50000);

        codes.add(code5);
        codes.add(code10);
        codes.add(code15);
        codes.add(code20);
        codes.add(code25);

        return codes;
    }
}
