package school.faang.feed_peter_griffin_BJS2_35967;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static final int THREADS_COUNT = 3;
    public static final int FOOD_AMOUNT_FROM = 1;
    public static final int FOOD_AMOUNT_TO = 20;
    public static final int AWAITING_TIME = 3;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            executorService.submit(() ->
                    new FoodDeliveryTask(character, new Random()
                            .nextInt(FOOD_AMOUNT_FROM, FOOD_AMOUNT_TO)).run());
        }

        executorService.shutdown();

        if (executorService.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
            System.out.println("All food delivery completed");
        } else {
            System.out.println("All food delivery failed");
            executorService.shutdownNow();
        }
    }
}
