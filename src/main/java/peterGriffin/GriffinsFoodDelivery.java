package peterGriffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREAD_AMOUNT = 3;
    private static final String[] CHARACTER_NAMES = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        int foodAmount = new Random().nextInt(100);
        Arrays.stream(CHARACTER_NAMES).forEach(character -> executor.submit(new FoodDeliveryTask(character, foodAmount)));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}
