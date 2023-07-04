package faang.school.godbless.peter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {

        Random random = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String griffin : characterNames) {
            executor.submit(() -> {
                FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(griffin, random.nextInt(100));
                foodDeliveryTask.run();
            });
        }

        executor.shutdown();
    }
}