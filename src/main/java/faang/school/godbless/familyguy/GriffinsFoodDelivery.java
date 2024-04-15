package faang.school.godbless.familyguy;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterName, new Random().nextInt(150) + 1);
            executorService.submit(foodDeliveryTask);
        }
        executorService.shutdown();
    }
}
