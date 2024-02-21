package faang.school.godbless.pieter_grifin;

import java.util.Random;
import java.util.concurrent.*;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {

            int randomFoodAmount = new Random().nextInt(5) + 1;

            Runnable foodDeliveryTask = new FoodDeliveryTask(characterName, randomFoodAmount);
            executor.submit(foodDeliveryTask);
        }
        executor.shutdown();
    }
}
