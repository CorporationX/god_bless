package school.faang.hungry_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        final int fixedThreadPool = 3;
        final int minRandom = 10;
        final int maxRandom = 50;

        ExecutorService executor = Executors.newFixedThreadPool(fixedThreadPool);
        String[] characterNames = {"Peter", "Lois", "Mes", "Chris", "Stewie"};

        Random random = new Random();

        for (String name : characterNames) {
            executor.submit(new FoodDeliveryTask(name, random.nextInt(maxRandom) + minRandom));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
