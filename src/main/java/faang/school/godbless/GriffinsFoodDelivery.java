package faang.school.godbless;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        int nThreads = 3;
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        for (String characterName : characterNames) {
            // always get +2 amount of food so that we can add "s" at the end of message(pizzas, tacos etc)
            int randomFoodAmount = new Random().nextInt(100) + 2;
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterName, randomFoodAmount);
            executor.submit(foodDeliveryTask);
        }
        executor.shutdown();
    }
}