package school.faang.BJS2_61171;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;
    private static final int TIMEOUT = 5;

    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            executor.submit(new FoodDeliveryTask(characterName, random.nextInt(1, 10)));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                System.err.print("Timed out waiting for threads to finish\n");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.print("Thread interrupted\n");
            executor.shutdownNow();
        }
    }
}
