package faang.school.godbless.r_edzie.parallelism.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int THREAD_AMOUNT = 3;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            executor.submit(new FoodDeliveryTask(characterName, random.nextInt(0, 100)));
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }
}
