package school.faang.FoodDelivery;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            int foodAmount = random.nextInt(500) + 1;
            FoodDeliveryTask foodDelivery = new FoodDeliveryTask(characterName, foodAmount);
            executor.submit(foodDelivery);
        }
        executor.shutdown();
    }
}
