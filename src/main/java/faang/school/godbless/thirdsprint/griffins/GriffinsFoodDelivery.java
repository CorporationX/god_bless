package faang.school.godbless.thirdsprint.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int MIN_FOOD_COUNT = 3;
    private static final int MAX_FOOD_COUNT = 17;

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Random random = new Random();

        for (String character : characterNames) {
            int foodAmount = random.nextInt(MAX_FOOD_COUNT) + MIN_FOOD_COUNT;
            executorService.execute(new FoodDeliveryTask(character, foodAmount));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
