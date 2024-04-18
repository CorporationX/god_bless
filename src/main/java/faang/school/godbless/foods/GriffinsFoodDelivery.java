package faang.school.godbless.foods;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {

    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            executor.submit(
                    new FoodDeliveryTask(characterName, random.nextInt(80))
            );
        }
        executor.shutdown();
        executor.awaitTermination(180000L, TimeUnit.MILLISECONDS);
        System.out.println("All deliveries done!");
    }
}

