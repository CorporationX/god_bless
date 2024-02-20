package faang.school.godbless.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    final static int THREADS = 3;
    public static void main(String... args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        for (String character : characterNames) {
            executor.submit(new FoodDeliveryTask(character, random.nextInt(1, 50)));
        }
        executor.shutdown();
        if (!executor.awaitTermination(60, TimeUnit.SECONDS))
            System.err.println("Threads didn't finish in 60 seconds!");
    }

}
