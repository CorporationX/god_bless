package faang.school.godbless.task.multithreading.feed.peter.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_LIMIT = 3;

    private static final String[] characterNames;
    private static final Random random;
    private static final ExecutorService executorService;

    static {
        characterNames = new String[]{"Peter", "Lois", "Meg", "Chris", "Stewie"};
        random = new Random();
        executorService = Executors.newFixedThreadPool(THREAD_POOL_LIMIT);
    }

    public static void main(String[] args) {
        IntStream.range(0, characterNames.length).forEach(i -> {
            executorService.submit(() -> {
                new FoodDeliveryTask(characterNames[i], getFoodAmount(), random).run();
            });
        });
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(2, TimeUnit.MINUTES)) {
                System.out.println("All characters have eaten");
            } else {
                System.out.println("Timeout! Not all tasks were finished in time.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int getFoodAmount() {
        return random.nextInt(50 - 5) + 5;
    }
}
