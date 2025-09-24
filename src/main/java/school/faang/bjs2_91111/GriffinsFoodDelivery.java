package school.faang.bjs2_91111;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int MAX_FOOD_AMOUNT = 100;
    private static final Random random = new Random();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            int foodAmount = random.nextInt(MAX_FOOD_AMOUNT) + 1;
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(character, foodAmount);
            executor.submit(foodDeliveryTask);
        }

        executor.shutdown();
    }
}
