package school.faang.bjs247736;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {

    private static final Random random = new Random();
    private static final int THREAD_POOL_AMOUNT = 3;
    private static final int RANDOM_FOOD_AMOUNT = random.nextInt(50) + 1;
    private static final String[] CHARACTER_NAMES = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_AMOUNT);

        for (String character : CHARACTER_NAMES) {
            FoodDeliveryTask deliveryTask = new FoodDeliveryTask(character, RANDOM_FOOD_AMOUNT);
            executorService.execute(deliveryTask);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("The delivery tasks were not completed in 5 minutes, "
                        + "we forcefully stop the ThreadPool");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("The main thread was interrupted while waiting, we forcefully stop the ThreadPool"
                    + e.getMessage());
            executorService.shutdownNow();
        }
    }
}