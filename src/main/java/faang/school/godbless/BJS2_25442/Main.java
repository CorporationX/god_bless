package faang.school.godbless.BJS2_25442;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        DeliveryService service = new DeliveryService();
        fillPromoCodes(service);

        List<Order> orders = getOrders();

        orders.forEach(order -> executorService.execute(() -> {
            service.processOrder(order, getRandomPromos());
        }));

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Daaaaem, something happened: {}", e.getMessage());
        }

        System.out.println("Done orders: " + service.getDoneOrders());
        System.out.println("Changed promocodes: " + service.getPromoCodes());
    }

    private static List<Order> getOrders() {
        List<Product> flatProducts = List.of(new Product("chair", 333),
                new Product("table", 444),
                new Product("mirror", 222),
                new Product("sofa", 111));
        Order flat = new Order(flatProducts);

        List<Product> bikeProducts = List.of(new Product("wheel", 549),
                new Product("accumulator", 325),
                new Product("kofr", 566),
                new Product("parking spot", 50));
        Order bike = new Order(bikeProducts);

        List<Order> orders = List.of(flat, bike);
        return orders;
    }

    private static List<String> getRandomPromos() {
        return List.of("promo" + ThreadLocalRandom.current().nextInt(0, 8),
                "promo" + ThreadLocalRandom.current().nextInt(0, 8),
                "promo" + ThreadLocalRandom.current().nextInt(0, 8),
                "promo" + ThreadLocalRandom.current().nextInt(0, 8),
                "promo" + ThreadLocalRandom.current().nextInt(0, 8));
    }

    private static void fillPromoCodes(DeliveryService service) {
        service.addPromoCode(new PromoCode("promo1", 5.5, LocalDate.now().minusDays(1), 300));
        service.addPromoCode(new PromoCode("promo2", 12, LocalDate.now().plusDays(8), 5000));
        service.addPromoCode(new PromoCode("promo3", 8.8, LocalDate.now().plusDays(3), 678));
        service.addPromoCode(new PromoCode("promo4", 4, LocalDate.now().minusDays(3), 300));
        service.addPromoCode(new PromoCode("promo5", 13, LocalDate.now().plusDays(3), 9999));
        service.addPromoCode(new PromoCode("promo6", 6.9, LocalDate.now().plusDays(5), 1000));
        service.addPromoCode(new PromoCode("promo7", 11, LocalDate.now().minusDays(3), 411));
        service.addPromoCode(new PromoCode("promo8", 3, LocalDate.now().plusDays(24), 1500));
    }
}
