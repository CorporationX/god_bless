package school.faang.sprint_3.task_43553;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int POOL_SIZE = 3;
    private static final int RANDOM_FOOD_AMOUNT = 50;
    private static final int BASE_FOOD_AMOUNT = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String name : characterNames) {
            executor.execute(new FoodDeliveryTask(name,
                    new Random().nextInt(RANDOM_FOOD_AMOUNT) + BASE_FOOD_AMOUNT));
        }

        executor.shutdown();
    }
}
