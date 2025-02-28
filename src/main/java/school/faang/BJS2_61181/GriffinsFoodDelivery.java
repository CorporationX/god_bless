package school.faang.BJS2_61181;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    private static final String ALL_TASKS_COMPLETED = "All tasks are completed!";
    private static final String ABORTING_TASKS = "Long task completion. Forced termination";
    private static final String ERROR_TASKS = "Task completion error: \n{}";
    private static final String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
    private static final int MAX_AMOUNT_OF_FOOD = 10;
    private static final int AMOUNT_OF_THREAD = 3;
    private static final Random random = new Random();
    private static final int TOTAL_DELIVERIES = 20;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_OF_THREAD);
        for (int i = 0; i < TOTAL_DELIVERIES; i++) {
            String character = characterNames[random.nextInt(characterNames.length)];
            int foodAmount = random.nextInt(MAX_AMOUNT_OF_FOOD);
            executorService.submit(new FoodDeliveryTask(character, foodAmount));
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info(ALL_TASKS_COMPLETED);
            } else {
                log.error(ABORTING_TASKS);
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(ERROR_TASKS, e.getMessage());
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
