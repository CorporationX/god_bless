package school.faang.feed_piter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        String[] characterNames = {"Piter", "Lois", "Meg", "Chris", "Stew"};
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        Random random = new Random();
        for (String character : characterNames) {
            int foodAmount = random.nextInt(100) + 1;
            executor.execute(new FoodDeliveryTask(character, foodAmount));
        }
        executor.shutdown();
    }
}