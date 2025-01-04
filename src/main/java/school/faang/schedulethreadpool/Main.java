package school.faang.schedulethreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        House house = new House(initializedRoom());

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        Runnable task = () -> {
            System.out.println("Task is running at " + System.currentTimeMillis());

            if (house.isFoodCollected()) {
                scheduler.shutdown();
                System.out.println("All the food in the house is collected!");
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, 30, TimeUnit.SECONDS);

    }

    private static List<Room> initializedRoom() {

        List<Room> rooms = new ArrayList<>();
        for (int i = 0, j = 0; i < 5; i++) {
            Room room = new Room(initializeFood(i));
            rooms.add(room);
        }
        return rooms;
    }

    private static List<Food> initializeFood(int roomNumber) {
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            foods.add(new Food("food for room number " + roomNumber + " ," + (i + 1)));
        }
        return foods;
    }

}
