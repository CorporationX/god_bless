package school.faang.task_48001;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class GriffinsFoodDelivery {
    private static final int NUMBER_OG_THREAD = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OG_THREAD);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (String character : characterNames) {
            int foodAmount = 10 + random.nextInt(50);
            executorService.submit(new FoodDeliveryTask(character, foodAmount));
        }

        executorService.shutdown();
    }
}
