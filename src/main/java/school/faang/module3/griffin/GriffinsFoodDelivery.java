package school.faang.module3.griffin;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    private static final int LOWER_BOUND_FOOD_AMOUNT = 1;
    private static final int UPPER_BOUND_FOOD_AMOUNT = 50;
    private static final int THREAD_COUNT = 3;

    private static final Random random = new Random();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            executor.submit(new FoodDeliveryTask(
                    character, random.nextInt(LOWER_BOUND_FOOD_AMOUNT, UPPER_BOUND_FOOD_AMOUNT))
            );
        }

        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread was interrupted", e);
        }
    }
}
