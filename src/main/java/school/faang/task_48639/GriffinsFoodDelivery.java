package school.faang.task_48639;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class GriffinsFoodDelivery {
    private static final int THREADS_QUANTITY = 3;
    private static final int FOOD_MIN_QUANTITY = 10;
    private static final int FOOD_MAX_QUANTITY = 50;

    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_QUANTITY);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String name : characterNames) {
            executorService.submit(new FoodDeliveryTask(name, random.nextInt(FOOD_MIN_QUANTITY, FOOD_MAX_QUANTITY)));
        }
        executorService.shutdown();
    }
}
