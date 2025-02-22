package school.faang.feedgriffins;

import jdk.jshell.spi.ExecutionControl;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int MAX_FOOD_COUNT = 3;
    private static final int THREADS_COUNT = 3;
    private static final Random RANDOM_FOOD_COUNT = new Random();

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        for (String character : characterNames) {
            executor.submit(new FoodDeliveryTask(character, 1 + RANDOM_FOOD_COUNT.nextInt(MAX_FOOD_COUNT)));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
