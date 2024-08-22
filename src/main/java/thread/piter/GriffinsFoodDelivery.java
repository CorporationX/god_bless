package thread.piter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static Random rand = new Random();

    public static void main(String[] args) {
        int threadCount = 3;

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < threadCount; i++) {
            String character = characterNames[rand.nextInt(characterNames.length)];
            int foodCount = rand.nextInt(10) + 1;
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(character, foodCount);
            executor.submit(() -> foodDeliveryTask.run());
        }
        executor.shutdown();
    }
}
