package bjs2_91047;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;
    private static final int MAX_FOOD_AMOUNT = 100;
    private static final int MIN_FOOD_AMOUNT = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();


        for (String character : characterNames) {
            int foodAmount = random.nextInt(MAX_FOOD_AMOUNT) + MIN_FOOD_AMOUNT;
            executor.execute(new FoodDeliveryTask(character, foodAmount));
        }

        ExecutorUtils.gracefullyShutdown(executor);
    }
}