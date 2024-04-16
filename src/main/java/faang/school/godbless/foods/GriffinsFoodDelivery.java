package faang.school.godbless.foods;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        Thread.sleep(10000);
        executor.shutdown();
    }
}

