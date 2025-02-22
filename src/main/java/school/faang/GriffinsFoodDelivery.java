package school.faang;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        final int maxThreads = 3;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            executor.submit(new FoodDeliveryTask(character));
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


