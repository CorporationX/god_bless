package school.faang.BJS2_61543;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Main {

    private static final int THREADS_AMOUNT = 5;
    private static final int TIME_AWAIT_TERMINATION_SEC = 30;
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

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
            LOGGER.log(Level.WARNING, "Thread interrupted, shutting down", e);
            executorService.shutdownNow();
        }

        if (house.allFoodCollected()) {
            LOGGER.info("All the food in the house is collected.");
        } else {
            LOGGER.info("The process ended before all the food was collected.");
        }
    }
}
