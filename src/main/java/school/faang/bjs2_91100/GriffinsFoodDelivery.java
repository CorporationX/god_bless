package school.faang.bjs2_91100;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREAD_COUNT = 3;
    private static final int SEEDS_START_RANDOM_FOOD = 1;
    private static final int SEEDS_END_RANDOM_FOOD = 30;

    public static void main(String[] args) {
        ExecutorService execute = Executors.newFixedThreadPool(THREAD_COUNT);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (int i = 0; i < characterNames.length; i++) {
            Random random = new Random();
            FoodDeliveryTask taskDelivery = new FoodDeliveryTask(
                    characterNames[i], random.nextInt(SEEDS_START_RANDOM_FOOD, SEEDS_END_RANDOM_FOOD));
            execute.submit(taskDelivery);
        }
        execute.shutdown();
    }
}
