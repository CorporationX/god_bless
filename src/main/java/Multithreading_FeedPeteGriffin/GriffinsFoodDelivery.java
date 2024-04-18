package Multithreading_FeedPeteGriffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    private static final int COUNT_THREADS = 3;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(COUNT_THREADS);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        Arrays.stream(characterNames)
                .toList()
                .forEach(characterName -> {
                    threadPool.execute(new FoodDeliveryTask(characterName, random.nextInt(1, 100)));
                });

        threadPool.shutdown();
        threadPool.awaitTermination(10, TimeUnit.SECONDS);
    }
}
