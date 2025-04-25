package faang;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final String[] CHARACTERS_NAMES = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
    private static final int MAX_FOOD_COUNT = 5;
    private static final int MIN_FOOD_COUNT = 1;

    public static void main(String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(3);
        final Random random = new Random();

        for (String character : CHARACTERS_NAMES) {
            FoodDeliveryTask task = new FoodDeliveryTask(character, random.nextInt(MIN_FOOD_COUNT, MAX_FOOD_COUNT + 1));
            executor.execute(task);
        }

        executor.shutdown();
    }
}
