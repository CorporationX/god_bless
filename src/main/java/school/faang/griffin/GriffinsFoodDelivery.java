package school.faang.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (String character : characterNames) {
            int foodAmount = random.nextInt(10, 100);
            FoodDeliveryTask task = new FoodDeliveryTask(character, foodAmount);
            executor.submit(task);
        }

        executor.shutdown();
    }
}
