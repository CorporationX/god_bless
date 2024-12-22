package school.faang.task_48394;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBER_THREADS = 25;
    private static final long COMPLETION_PERIOD = 1;
    private static final long DELAY = 0;
    private static final int ROOM_LIMIT = 2;
    private static final int QUANTITY_ROOMS = 50;

    public static void main(String[] args) {
        House house = new House(QUANTITY_ROOMS);
        ScheduledExecutorService executor = Executors
                .newScheduledThreadPool(NUMBER_THREADS);
        List<Food> foodList = List.of(
                new Food("Jerry"),
                new Food("Cheese"),
                new Food("Burger")
        );
        house.initializeRooms(foodList);

        executor.scheduleAtFixedRate(() -> {
            if (!house.collectFood(ROOM_LIMIT)) {
                executor.shutdown();
            }
        }, DELAY, COMPLETION_PERIOD, TimeUnit.SECONDS);

        try {
            long programTimeout = house.getQuantityRooms() / ROOM_LIMIT
                    * COMPLETION_PERIOD * 2;
            if (!executor.awaitTermination(programTimeout, TimeUnit.SECONDS)) {
                log.error("Not all tasks completed within the specified time period"
                        + ", forced termination");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while waiting {}", e.getMessage());
            executor.shutdownNow();
        }

        log.info("The food in the house is collected, only {} units",
                house.getTotalListFood().size());
    }
}
