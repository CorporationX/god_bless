package faang.school.godbless.bjs2_24047;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;
    private static final int MAX_RANDOM_VALUE = 50;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < characterNames.length; i++) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterNames[i], new Random().nextInt(MAX_RANDOM_VALUE) + 1);
            executorService.submit(foodDeliveryTask);
        }

        executorService.shutdown();
    }

    private static String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
