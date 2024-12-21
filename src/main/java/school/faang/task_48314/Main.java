package school.faang.task_48314;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int CORE_POOL_SIZE = 5;

    private static final int ROOM_COUNT = 10;
    private static final int FOOD_COUNT_PER_ROOM = 5;

    private static final int INITIAL_DELAY = 0;
    private static final int PERIOD = 1;
    private static final TimeUnit UNIT_OF_TIME = TimeUnit.SECONDS;

    private static final House house = new House();

    public static void main(String[] args) {
        initData();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        executor.scheduleAtFixedRate(() -> {
            if (house.isAllRoomsCleared()) {
                executor.shutdown();
            } else {
                house.collectFood();
            }
        }, INITIAL_DELAY, PERIOD, UNIT_OF_TIME);

        try {
            if (executor.awaitTermination(10, UNIT_OF_TIME)) {
                log.info("Task completed successfully.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void initData() {
        for (int i = 0; i < ROOM_COUNT; i++) {
            Room room = new Room();

            for (int j = 0; j < FOOD_COUNT_PER_ROOM; j++) {
                room.addFood(getRandomFood());
            }

            house.addRoom(room);
        }
    }

    private static Food getRandomFood() {
        FoodName[] foodNames = FoodName.values();
        int index = (int) (Math.random() * foodNames.length);
        return new Food(foodNames[index]);
    }

}
