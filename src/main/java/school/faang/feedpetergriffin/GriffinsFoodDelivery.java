package school.faang.feedpetergriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            int foodAmount = new Random().nextInt(100) + 1; // Random food amount between 1 and 100
            FoodDeliveryTask task = new FoodDeliveryTask(character, foodAmount);
            executorService.submit(task);
        }

        executorService.shutdown();
    }
}
