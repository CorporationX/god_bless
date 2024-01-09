package faang.school.godbless.alexbulgakoff.multithreading.parallelism.feedpitergriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Alexander Bulgakov
 */

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (String name : characterNames) {
            executorService.submit(new FoodDeliveryTask(name, new Random().nextInt(20)));
        }

        executorService.shutdown();
    }
}
