package school.faang.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        final int THREAD_PULL_COUNT = 3;
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_PULL_COUNT);
        Random random = new Random();

        for (String characterName : characterNames) {
            FoodDeliveryTask foodTask = new FoodDeliveryTask(characterName, random.nextInt(19) + 1);
            executor.submit(foodTask);
        }
        executor.shutdown();
    }
}
