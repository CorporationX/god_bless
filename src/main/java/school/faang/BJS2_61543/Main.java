package school.faang.BJS2_61543;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int THREADS_AMOUNT = 5;
    private static final int TIME_AWAIT_TERMINATION_SEC = 30;

    public static void main(String[] args) {

        House house = new House();
        house.initializeHouse();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREADS_AMOUNT);

        IntStream.range(0, THREADS_AMOUNT).forEach(i -> executorService.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                executorService.shutdown();
            }
        }, 0, 3, TimeUnit.SECONDS));

        try {
            if (!executorService.awaitTermination(TIME_AWAIT_TERMINATION_SEC, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Thread interrupted, shutting down", e);
            executorService.shutdownNow();
        }

        if (house.allFoodCollected()) {
            log.info("All the food in the house is collected.");
        } else {
            log.info("The process ended before all the food was collected.");
        }
    }
}
