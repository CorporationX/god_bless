package school.faang.feedthepitergriphen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        int threadCount = 3;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random rand = new Random();
        for (String characterName : characterNames) {
            int foodValue = rand.nextInt(100) + 1;
            executor.submit(new FoodDeliveryTask(characterName, foodValue));
        }
        executor.shutdown();
        try {
            int second = 10;
            if (!executor.awaitTermination(second, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        }


    }
}
