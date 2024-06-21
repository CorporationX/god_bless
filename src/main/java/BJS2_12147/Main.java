package BJS2_12147;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Random random = new Random();

        for (String character : characterNames) {
            int foodAmount = random.nextInt(50) + 1;
            executorService.submit(new FoodDeliveryTask(character, foodAmount));
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
