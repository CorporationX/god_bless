package faang.school.godbless.multithreading_parallelism.task_2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
    private static final int MAX_FOOD_AMOUNT = 50;
    private static final int THREAD_COUNT = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        Arrays.stream(characterNames).forEach(character ->
                executor.submit(new FoodDeliveryTask(character, new Random().nextInt(1, MAX_FOOD_AMOUNT + 1)))
        );

        executor.shutdown();
    }
}
