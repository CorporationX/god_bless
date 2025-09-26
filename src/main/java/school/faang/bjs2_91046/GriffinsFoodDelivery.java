package school.faang.bjs2_91046;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {

    public static void main(String[] args) {

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Random random = new Random();

        ExecutorService executor = Executors.newFixedThreadPool(characterNames.length);

        for (String c : characterNames) {
            int foodAmount = random.nextInt(100) + 1;
            executor.submit(new FoodDeliveryTask(c, foodAmount));
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.warn("Delivery is taking too long ...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Something went wrong ...");
            throw new RuntimeException(e);
        }
        log.info("All orders have been delivered!");
        executor.shutdownNow();
    }
}
