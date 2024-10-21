package school.faang.BJS2_35991_FeedPeterGriffin;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    private static final String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
    private static final int THREADS_COUNT = 3;
    private static final int MIN_FOOD_AMOUNT = 1;
    private static final int MAX_FOOD_AMOUNT = 60;
    private static final int TERMINATION_WAIT_SECONDS = 10;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(THREADS_COUNT);

        for (String character: characterNames) {
            int foodAmount = ThreadLocalRandom.current().nextInt(MIN_FOOD_AMOUNT, MAX_FOOD_AMOUNT + 1);
            log.info("Submitting food delivery task for {} with {} units of food.", character, foodAmount);
            service.submit(new FoodDeliveryTask(character, foodAmount));
        }

        service.shutdown();
        try {
            if (service.awaitTermination(TERMINATION_WAIT_SECONDS, TimeUnit.SECONDS)) {
                log.info("All the threads have finished successfully!");
            } else {
                log.warn("Not all threads have finished in time! Shutting down executor service!");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("The thread was interrupted while waiting for tasks to finish. Shutting down executor service.", e);
            service.shutdownNow();
            throw new IllegalStateException(
                    "The thread was interrupted while waiting for tasks to finish. Shutting down executor service.",
                    e
            );
        }
    }
}
