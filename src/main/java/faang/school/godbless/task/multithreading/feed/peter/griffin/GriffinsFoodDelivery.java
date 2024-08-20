package faang.school.godbless.task.multithreading.feed.peter.griffin;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class GriffinsFoodDelivery {
    private static final int THREAD_POOL_LIMIT = 3;

    private static final String[] characterNames = new String[]{"Peter", "Lois", "Meg", "Chris", "Stewie"};
    private static final Random random = new Random();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_LIMIT);

    public static void main(String[] args) {
        IntStream.range(0, characterNames.length)
                .forEach(i -> {
                    executorService.submit(new FoodDeliveryTask(characterNames[i], getFoodAmount()));
                });
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(2, TimeUnit.MINUTES)) {
                log.info("\nAll characters have eaten");
            } else {
                log.warn("\nTimeout! Not all tasks were finished in time.");
            }
        } catch (InterruptedException exception) {
            log.error("Interrupted exception: {}", exception.getMessage());
        }
    }

    private static int getFoodAmount() {
        return random.nextInt(50 - 5) + 5;
    }
}
