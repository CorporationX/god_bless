package faang.school.godbless.BJS2_24027;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            int randomFoodAmount = ThreadLocalRandom.current().nextInt(1, 6);

            FoodDeliveryTask task = new FoodDeliveryTask(character, randomFoodAmount);
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}
