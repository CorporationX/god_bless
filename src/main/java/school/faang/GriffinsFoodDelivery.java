package school.faang;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (String name : characterNames) {
            executorService.execute(new FoodDeliveryTask(name, random.nextInt(100) + 1));
        }
        executorService.shutdown();
    }
}
