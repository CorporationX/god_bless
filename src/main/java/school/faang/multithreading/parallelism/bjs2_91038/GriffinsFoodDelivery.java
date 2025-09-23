package school.faang.multithreading.parallelism.bjs2_91038;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {

    private static final int THREADS = 3;
    private static final int FOOD_AMOUNT_START_BORDER = 4;
    private static final int FOOD_AMOUNT_END_BORDER = 20;
    private static final int AWAIT_TIMEOUT = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            executorService.execute(new FoodDeliveryTask(characterName,
                    new Random().nextInt(FOOD_AMOUNT_START_BORDER, FOOD_AMOUNT_END_BORDER)));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_TIMEOUT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}