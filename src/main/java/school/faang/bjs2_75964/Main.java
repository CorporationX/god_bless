package school.faang.bjs2_75964;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        PromoCode promo1 = new PromoCode("DISCOUNT10", 10, LocalDate.now().plusDays(1), 100);
        PromoCode promo2 = new PromoCode("BIGSALE20", 20, LocalDate.now().plusDays(1), 150);

        deliveryService.addPromoCode(promo1);
        deliveryService.addPromoCode(promo2);

        List<PromoCode> promoCodes = List.of(promo1, promo2);

        ExecutorService poolThreads = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.range(0, NUM_THREADS).forEach(
                i -> {
                    Order order = new Order(Set.of(
                            new Product("Burger", 120 + 10 * i),
                            new Product("Fries", 30)));

                    poolThreads.execute(() -> {
                        try {
                            deliveryService.processOrder(order, promoCodes);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    });
                }
        );

        shutdownPool(poolThreads);
    }

    private static void shutdownPool(ExecutorService pool) {
        pool.shutdown();
        try {
            boolean isClose = pool.awaitTermination(5, TimeUnit.SECONDS);
            if (!isClose) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread stooped error");
            pool.shutdownNow();
        }
    }
}
