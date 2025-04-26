package school.faang.food;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int COUNT_THREAD_POOL = 3;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 50;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD_POOL);

        String[] nameUnit = {"Peter", "Lois", "Meg", "Chris", "Stewie", "Brain"};

        for (String name : nameUnit) {
            int randomValue = MIN_VALUE + (int) (Math.random() * (MAX_VALUE - MIN_VALUE + 1));
            executorService.execute(new FoodDeliveryTask(name, randomValue));
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
