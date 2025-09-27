package bjs2_91047;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (String character : characterNames) {
            int foodAmount = random.nextInt(100) + 1; // 1–100 еды
            executor.execute(new FoodDeliveryTask(character, foodAmount));
        }

        executor.shutdown();
    }
}