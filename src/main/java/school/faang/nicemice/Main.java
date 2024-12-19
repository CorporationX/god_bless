package school.faang.nicemice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int DELAY = 30;
    private static final int FREQUENCY = 5;

    public static void main(String[] args) {
        House house = new House();

        List<Room> initialRooms = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            List<Food> foodList = new ArrayList<>();
            foodList.add(new Food("Еда " + i));
            foodList.add(new Food("Напиток " + i));
            initialRooms.add(new Room("Комната " + i, foodList));
        }

        house.initializeHouse(initialRooms);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            executor.scheduleAtFixedRate(() -> {
                house.collectFood();
                if (house.allFoodCollected()) {
                    System.out.println("Еда в доме собрана!");
                    executor.shutdown();
                }
            }, DELAY, FREQUENCY, TimeUnit.SECONDS);
        }
    }
}
