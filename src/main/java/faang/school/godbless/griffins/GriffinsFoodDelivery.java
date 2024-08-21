package faang.school.godbless.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            executorService.execute(new FoodDeliveryTask(characterName, new Random().nextInt(100)));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
