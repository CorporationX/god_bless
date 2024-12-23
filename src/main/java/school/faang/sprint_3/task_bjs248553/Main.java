package school.faang.sprint_3.task_bjs248553;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int HOUSE_ROOM_CAPACITY = 21;
    private static final int HOUSE_FOOD_PER_ROOM_CAPACITY = 4;
    private static final int EXECUTORS_POOL_SIZE = 5;
    private static final int EXECUTORS_INITIAL_DELAY_SECONDS = 0;
    private static final int EXECUTORS_PERIOD_SECONDS = 10;
    private static final int EXECUTORS_TERMINATION_TIMEOUT_SECONDS = 30;

    public static void main(String[] args) {
        House house = TestDataGenerator.generateHouse(HOUSE_ROOM_CAPACITY, HOUSE_FOOD_PER_ROOM_CAPACITY);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(EXECUTORS_POOL_SIZE);

        IntStream.range(0, EXECUTORS_POOL_SIZE).forEach(i -> {
            if (!executor.isShutdown()) {
                executor.scheduleAtFixedRate(() -> {
                    if (house.isFoodCollected()) {
                        executor.shutdown();
                    }
                    house.collectFood();
                }, EXECUTORS_INITIAL_DELAY_SECONDS, EXECUTORS_PERIOD_SECONDS, TimeUnit.SECONDS);
            }
        });


        try {
            if (!executor.awaitTermination(EXECUTORS_TERMINATION_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.warn("Tasks did not complete in termination time, forcing shutdown.");
                executor.shutdownNow();
            } else {
                log.info("All threads was stopped correctly");
            }
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
        log.info("Collected food size: {}", house.getCollectedFood().size());
    }
}