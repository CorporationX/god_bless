package faang.school.godbless.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private final static int COUNT_THREADS = 3;

    public static void main(String... args) {
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            int foodAmount = new Random().nextInt(100) + 1;
            executorService.submit(new FoodDeliveryTask(characterName, foodAmount));
        }

        executorService.shutdown();

        try {
            boolean finished = executorService.awaitTermination(1, TimeUnit.MINUTES);
            if (finished) {
                System.out.println("All Griffins are fed.");
            } else {
                System.out.println("Timed out.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
