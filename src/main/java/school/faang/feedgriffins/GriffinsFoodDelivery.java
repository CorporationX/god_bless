package school.faang.feedgriffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int MAX_FOOD_COUNT = 3;
    private static final Random RANDOM_FOOD_COUNT = new Random();

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String character : characterNames) {
            executor.submit(new FoodDeliveryTask(character, 1 + RANDOM_FOOD_COUNT.nextInt(MAX_FOOD_COUNT)));
        }

        executor.shutdown();
    }
}
