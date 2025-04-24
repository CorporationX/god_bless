package school.faang.bjs2_72124;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    private static final int THREADS_COUNT = 3;
    private static final int UPPER_BORDER = 10;
    private static final int LOWER_BORDER = 1;

    private final String[] characterNames = { "Peter", "Lois", "Meg", "Chris", "Stewie" };
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
    private final Random random = new Random();

    public void deliverFood() {
        for (String characterName : characterNames) {
            executorService.execute(new FoodDeliveryTask(characterName, random.nextInt(LOWER_BORDER, UPPER_BORDER)));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            executorService.shutdownNow();
        }
    }
}