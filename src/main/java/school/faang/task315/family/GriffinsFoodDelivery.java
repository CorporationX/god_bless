package school.faang.task315.family;

import school.faang.task315.feed.FoodDeliveryTask;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String str : characterNames) {
            int foodAmount = new Random().nextInt(50);
            executor.submit(new FoodDeliveryTask(str, foodAmount));
        }
        executor.shutdown();

        final boolean done = executor.awaitTermination(1, TimeUnit.MINUTES);
        if (!done) {
            executor.shutdownNow();
        }
    }
}
