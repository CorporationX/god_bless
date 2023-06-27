package faang.school.godbless.peter.griffin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            int random = (int) (1 + Math.random() * 20);
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterName, random);
            executorService.submit(foodDeliveryTask);
        }
        executorService.shutdown();
    }
}
