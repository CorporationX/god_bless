package school.faang.sprint3.task_61141;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREADS_COUNT = 3;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        Arrays.stream(characterNames)
                .forEach(name -> executor.execute(new FoodDeliveryTask(name, RANDOM.nextInt(0, 100))));
        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            throw new RuntimeException("Error in the thread operation", e);
        }
    }
}
