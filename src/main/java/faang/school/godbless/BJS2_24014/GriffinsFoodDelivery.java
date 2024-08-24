package faang.school.godbless.BJS2_24014;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        var executorService = Executors.newFixedThreadPool(3);

        for (String characterName : characterNames) {
            int foodAmount = new Random().nextInt(1, 51);
            var foodDeliveryTask = new FoodDeliveryTask(characterName, foodAmount);
            executorService.submit(foodDeliveryTask);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
