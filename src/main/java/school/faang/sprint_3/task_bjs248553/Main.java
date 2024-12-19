package school.faang.sprint_3.task_bjs248553;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class Main {
    private static final int HOUSE_ROOM_CAPACITY = 100;
    private static final int HOUSE_FOOD_PER_ROOM_CAPACITY = 4;
    private static final int EXECUTORS_POOL_SIZE = 5;
    private static final int EXECUTORS_ROOM_PER_THREAD = 10;
    private static final int EXECUTORS_INITIAL_DELAY_SECONDS = 0;
    private static final int EXECUTORS_PERIOD_SECONDS = 2;
    private static final int EXECUTORS_TERMINATION_TIMEOUT_SECONDS = 20;

    public static void main(String[] args) {
        AtomicBoolean isCompleted = new AtomicBoolean(false);
        House house = TestDataGenerator.generateHouse(HOUSE_ROOM_CAPACITY, HOUSE_FOOD_PER_ROOM_CAPACITY);
        log.info("House was initialized {} ", house);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(EXECUTORS_POOL_SIZE);
        executor.scheduleAtFixedRate(() -> {
            if (house.getRoomsRemaining().get() <= 0) {
                log.info("No rooms remaining, shutting down executor.");
                isCompleted.set(true);
                executor.shutdown();
            }
            house.collectFood(EXECUTORS_ROOM_PER_THREAD);
        }, EXECUTORS_INITIAL_DELAY_SECONDS, EXECUTORS_PERIOD_SECONDS, TimeUnit.SECONDS);

        try {
            while (!isCompleted.get()
                    && !executor.awaitTermination(EXECUTORS_TERMINATION_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.info("Waiting tasks to complete...");
            }
            log.info("All threads was stopped correctly");
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
        log.info("Collected food size: {}", house.getCollectedFood().size());
        boolean allRoomsCleared = house.getRooms().stream()
                .allMatch(room -> room.getFoods().isEmpty());
        log.info("All rooms was cleared: {}", allRoomsCleared);
    }
}