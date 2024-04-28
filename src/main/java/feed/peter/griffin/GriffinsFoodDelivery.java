package feed.peter.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        final int NUM_THREADS = 3;
        final int WAITING_TIME = 10;
        Random random = new Random();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterName, random.nextInt(100));
            executor.submit(foodDeliveryTask);
        }

        try {
            if (!executor.awaitTermination(WAITING_TIME, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException exception) {
            executor.shutdownNow();
        }
    }
}
