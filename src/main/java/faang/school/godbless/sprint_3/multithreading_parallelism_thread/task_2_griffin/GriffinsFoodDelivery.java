package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_2_griffin;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static final Random random = new SecureRandom();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String name : characterNames) {
            int amountFood = random.nextInt(1, 20);
            executorService.submit(new FoodDeliveryTask(name, amountFood));
        }

        executorService.shutdown();
    }
}
