package school.faang.sprint_3.task_48263;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMBER_OF_THREADS = 5;
    private static final int START_SCHEDULE = 0;
    private static final int REPEAT_SCHEDULE = 30;
    private static final int IS_COLLECTED_CHECK_DELAY = 10000;
    private static final int AMOUNT_OF_ROOMS = 10;
    private static final int AMOUNT_OF_FOOD_PER_ROOM = 10;

    public static void main(String[] args) {
        House house = generateHouse(AMOUNT_OF_ROOMS, AMOUNT_OF_FOOD_PER_ROOM);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);

        try {
            for (int i = 0; i < NUMBER_OF_THREADS; i++) {
                executorService.scheduleAtFixedRate(house::collectFood,
                        START_SCHEDULE,
                        REPEAT_SCHEDULE,
                        TimeUnit.SECONDS);
            }
            Thread.sleep(IS_COLLECTED_CHECK_DELAY);
            if (!house.isAllFoodCollected()) {
                throw new RuntimeException("All food was not collected");
            }
            System.out.println("All food collected");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        } finally {
            executorService.shutdown();
        }
    }

    private static House generateHouse(int amountOfRooms, int amountOfFoodPerRoom) {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < amountOfRooms; i++) {
            List<Food> foodList = new ArrayList<>();
            for (int j = 0; j < amountOfFoodPerRoom; j++) {
                foodList.add(new Food("Food " + j + " in room " + i));
            }
            rooms.add(new Room(foodList));
        }
        return new House(rooms);
    }
}
