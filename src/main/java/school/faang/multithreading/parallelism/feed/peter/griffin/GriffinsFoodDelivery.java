package school.faang.multithreading.parallelism.feed.peter.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private final static int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            int foodAmount = new Random().nextInt(100) + 1;
            executor.submit(new FoodDeliveryTask(characterName, foodAmount));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
