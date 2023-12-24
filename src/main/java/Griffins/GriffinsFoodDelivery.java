package Griffins;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterName);
            executorService.submit(foodDeliveryTask);
        }
        executorService.shutdown();
    }
}
