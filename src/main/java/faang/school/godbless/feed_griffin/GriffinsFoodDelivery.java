package faang.school.godbless.feed_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        Random randomizer = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            int foodQuantity = randomizer.nextInt(1, 100);
            FoodDeliveryTask task = new FoodDeliveryTask(characterName, foodQuantity);
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}
