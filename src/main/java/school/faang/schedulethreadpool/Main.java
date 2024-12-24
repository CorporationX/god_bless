package school.faang.schedulethreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        House house = new House();
        initializedHouse(house);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        Runnable task = () -> {
            System.out.println("Task is running at " + System.currentTimeMillis());

            if (house.collectFood()) {
                scheduler.shutdown();
                System.out.println("All the food in the house is collected!");
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, 30, TimeUnit.SECONDS);

    }

    private static void initializedHouse(House house) {
        List<Food> foods = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            foods.add(new Food("food" + i + 1));
        }
        List<Room> rooms = new ArrayList<>();
        for (int i = 0, j = 0; i < 5; i++) {
            Room room = new Room();
            while (room.getFoods().size() < 4) {
                room.addFood(foods.get(j));
                j++;
            }
            rooms.add(room);
        }
        for (int i = 0; i < 5; i++) {
            house.addRoom(rooms.get(i));
        }
    }

}
