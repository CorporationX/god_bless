package school.faang.sprint_3.task_47766;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREADS_POOL_SIZE = 3;
    private static final int MAX_DELIVERY_AMOUNT = 100;

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_POOL_SIZE);

        for (String characterName : characterNames) {
            executorService.execute(new FoodDeliveryTask(characterName, random.nextInt(MAX_DELIVERY_AMOUNT)));
        }

        executorService.shutdown();
    }
}
