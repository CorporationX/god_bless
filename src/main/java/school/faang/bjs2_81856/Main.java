package school.faang.bjs2_81856;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBER_OF_ROOMS = 10;
    private static final int THREADS_COUNT = 5;
    private static final int INITIAL_DELAY = 0;
    private static final int PERIOD = 10;

    public static void main(String[] args) {
        House house = new House(createRooms());

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREADS_COUNT);
        for (int i = 0; i < THREADS_COUNT; i++) {
            executorService.scheduleAtFixedRate(() -> {
                house.collectFood();
                if (house.allFoodCollected()) {
                    executorService.shutdown();
                }
            }, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS);
        }

        try {
            if (!executorService.awaitTermination(3, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Превышено время ожидания завершения потоков!");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        log.info("Еда в доме собрана!");
    }

    private static List<Room> createRooms() {
        List<Room> rooms = new LinkedList<>();

        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
            rooms.add(new Room(createFoods(i + 1)));
        }

        return rooms;
    }

    private static List<Food> createFoods(int foodCount) {
        List<Food> foods = new LinkedList<>();

        for (int i = 0; i < foodCount; i++) {
            foods.add(new Food("Food " + i));
        }

        return foods;
    }
}
