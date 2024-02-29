package faang.school.godbless.griffen;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int QUANTITY_THREAD_POOL = 3;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(QUANTITY_THREAD_POOL);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (String characterName : characterNames) {
            executorService.submit(new FoodDeliveryTask(characterName, random.nextInt(0, 100)));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
