package school.faang.griffins;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    private static final int THREAD_NUMS = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMS);
        String[] characterNames = {"Peter", "Louis", "Meg", "Chris", "Stewie"};

        for (String string : characterNames) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(string);
            executor.submit(foodDeliveryTask);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("The running was interrupted", e);
            executor.shutdownNow();
        }
    }
}
