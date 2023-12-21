package faang.school.godbless.multithreading_parallelism.feed_peter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Random random = new Random();
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};


        for (int i = 0; i < 3; i++) {
            executorService.execute(new FoodDeliveryTask(characterNames[random.nextInt(characterNames.length)], random.nextInt(1, 50)));
        }

        executorService.shutdown();

    }
}
