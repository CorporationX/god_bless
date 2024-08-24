package faang.school.godbless.sprint3.BJS2_23976;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterName, new Random().nextInt(50));
            executorService.submit(foodDeliveryTask::run);
        }
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                log.info("All food have been delivered");
            } else {
                log.info("Timeout: ExecutorService did not shut down in time.");
            }
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Interrupted exception: {}", e.getMessage());
        }
    }
}
