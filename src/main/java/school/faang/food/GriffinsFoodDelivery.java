package school.faang.food;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {

    private static final int COUNT_THREAD_POOL = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD_POOL);

        String[] nameUnit = {"Peter", "Lois", "Meg", "Chris", "Stewie", "Brain"};
        int minValue = 1;
        int maxValue = 50;
        for (String s : nameUnit) {
            int randomValue = minValue + (int) (Math.random() * (maxValue - minValue + 1));
            executorService.execute(new FoodDeliveryTask(s, randomValue));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
