package faang.school.godbless.sprint4.multithreading_parallelism_thread.task2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Random random = new Random();

        for (int i = 0; i < characterNames.length; i++) {
            executor.submit(new FoodDeliveryTask(characterNames[i], random.nextInt(50) + 1));
        }
        executor.shutdown();
    }
}
