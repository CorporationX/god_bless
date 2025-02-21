package school.faang.feedthepitergriphen;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    private static final Integer TERMINATION_TIMEOUT_SECONDS = 10;

    public static void main(String[] args) {
        int threadCount = 3;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random rand = new Random();
        for (String characterName : characterNames) {
            int foodValue = rand.nextInt(100) + 1;
            executor.submit(new FoodDeliveryTask(characterName, foodValue));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TERMINATION_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());

        }
    }
}
