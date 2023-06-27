package faang.school.godbless.parallelismAndThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            executorService.submit(new FoodDeliveryTask(characterName, (int) (Math.random() * 50) + 10));
        }

        executorService.shutdown();
    }
}
