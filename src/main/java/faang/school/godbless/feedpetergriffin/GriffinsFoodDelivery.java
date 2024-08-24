package faang.school.godbless.feedpetergriffin;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<String> characterNames = List.of("Peter", "Lois", "Meg", "Chris", "Stewie");
        Random random = new Random();

        for (String character : characterNames) {
            int foodAmount = random.nextInt(50) + 1;
            FoodDeliveryTask task = new FoodDeliveryTask(character, foodAmount);
            executorService.submit(task);
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