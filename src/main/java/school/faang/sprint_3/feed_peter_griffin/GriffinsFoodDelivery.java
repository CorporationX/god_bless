package school.faang.sprint_3.feed_peter_griffin;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    private static final Random random = new Random();
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        String [] characters = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String character : characters) {
            threadPool.submit(new FoodDeliveryTask(character, random.nextInt(10) + 1));
        }
        try {
            if (!threadPool.awaitTermination(20, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted" + e.getMessage());
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
