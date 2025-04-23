package school.faang.peter_griffen;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            executorService.execute(new FoodDeliveryTask(characterName, threadLocalRandom.nextInt(1, 50)));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("InterruptedException was thrown", e);
            executorService.shutdownNow();
        }
    }
}
