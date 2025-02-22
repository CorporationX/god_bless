package school.faang.Griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;
    private static final int MAX_FOOD_AMOUNT = 100;
    private static final int AWAIT_TERMINATION_TIMEOUT = 60;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Random random = new Random();

        for (String character : characterNames) {
            int foodAmount = random.nextInt(MAX_FOOD_AMOUNT) + 1;
            executor.execute(new FoodDeliveryTask(character, foodAmount));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}