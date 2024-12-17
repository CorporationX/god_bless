package school.faang.sprint_3.task_43553;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int POOL_SIZE = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String name : characterNames) {
            executor.execute(new FoodDeliveryTask(name, new Random().nextInt(50) + 1));
        }

        executor.shutdown();
    }
}
