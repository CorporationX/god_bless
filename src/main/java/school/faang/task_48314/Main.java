package school.faang.task_48314;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int CORE_POOL_SIZE = 5;

    private static final int ROOMS_COUNT = 10;
    private static final int MAX_FOOD_COUNT = 5;

    private static final House house = new House();

    public static void main(String[] args) {
        initData();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        final int initialDelay = 0;
        final int period = 10;
        executor.scheduleAtFixedRate(house::collectFood, initialDelay, period, TimeUnit.SECONDS);
    }

    private static void initData() {
        for (int i = 0; i < ROOMS_COUNT; i++) {
            Room room = new Room();

            int endIndex = (int) (Math.random() * (MAX_FOOD_COUNT + 1));
            for (int j = 0; j < endIndex; j++) {
                room.addFood(getRandomFood());
            }

            house.addRoom(room);
        }
    }

    private static Food getRandomFood() {
        FoodType[] foodTypes = FoodType.values();
        int index = (int) (Math.random() * foodTypes.length);
        return new Food(foodTypes[index]);
    }

}
