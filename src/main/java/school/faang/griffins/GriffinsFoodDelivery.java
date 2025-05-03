package school.faang.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int EXECUTION_TIMEOUT = 60;
    private static final int MAX_EAT = 13;

    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            int foodAmount = random.nextInt(MAX_EAT);
            FoodDeliveryTask task = new FoodDeliveryTask(character, foodAmount);
            executorService.submit(task);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(EXECUTION_TIMEOUT, java.util.concurrent.TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}