package school.faang.sprint_4.task_51073;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBER_OF_USERS = 100;
    private static final int NUMBER_OF_PROMO_CODES = 50;
    private static final int MIN_ORDER_RATE = 1000;
    private static final Random RANDOM = new Random();
    private static final int MAX_PRODUCTS_PER_ORDER = 10;
    private static final int PRICE_GENERATION_RATE = 100;

    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    private static final int AWAIT_TIME = 5;

    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        generatePromoCodes(deliveryService);
        startAllTasks(deliveryService);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_TIME, TimeUnit.SECONDS)) {
                log.info("Await timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Thread interrupted. Shutting down...");
            executorService.shutdownNow();
        }
    }

    private static void startAllTasks(DeliveryService deliveryService) {
        for (int i = 0; i < NUMBER_OF_USERS; i++) {
            executorService.submit(() -> {
                List<Product> products = new ArrayList<>();
                for (int j = 1; j <= RANDOM.nextInt(MAX_PRODUCTS_PER_ORDER); j++) {
                    products.add(new Product(String.valueOf(j), j * PRICE_GENERATION_RATE));
                }
                deliveryService.processOrder(new Order(products),
                        deliveryService.getRandomPromoCodes());
            });
        }
    }

    private static void generatePromoCodes(DeliveryService deliveryService) {
        for (int i = 1; i <= NUMBER_OF_PROMO_CODES; i++) {
            deliveryService.addPromoCode(
                    new PromoCode(String.valueOf(i),
                            i,
                            LocalDate.now().plusDays(i),
                            i * MIN_ORDER_RATE));
        }
    }
}
