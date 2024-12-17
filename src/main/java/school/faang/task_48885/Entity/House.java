package school.faang.task_48885.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final List<Room> roomInHouse = new ArrayList<>();
    private static final Random rand = new Random();
    private static final Set<Food> collectedFood = new HashSet<>();

    public static void collectFood(List<Room> rooms) {
        synchronized (collectedFood) {
            Room room = rooms.get(rand.nextInt(rooms.size()));
            if (!room.getFoodList().isEmpty()) {
                collectedFood.addAll(room.getFoodList());
                room.getFoodList().clear();
            }

            Room room2;
            do {
                room2 = rooms.get(rand.nextInt(rooms.size()));
            } while (room2 == room);
            if (!room2.getFoodList().isEmpty()) {
                collectedFood.addAll(room2.getFoodList());
                room2.getFoodList().clear();
            }
        }
    }

    public static void main(String[] args) {
        Room kitchen = new Room();
        Room livingRoom = new Room();
        Room bedroom = new Room();

        kitchen.addFood(new Food("Apple"));
        kitchen.addFood(new Food("Banana"));
        livingRoom.addFood(new Food("Sandwich"));
        livingRoom.addFood(new Food("Juice"));
        bedroom.addFood(new Food("Chocolate"));
        bedroom.addFood(new Food("Cookies"));

        roomInHouse.add(kitchen);
        roomInHouse.add(livingRoom);
        roomInHouse.add(bedroom);

        System.out.println("Before food collected:");
        System.out.println(roomInHouse);
        Runnable task = (() -> {
            synchronized (roomInHouse) {
                collectFood(roomInHouse);
            }
        });
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            scheduler.scheduleAtFixedRate(task, 1, 30, TimeUnit.SECONDS);
        }

        try {
            if (scheduler.awaitTermination(15, TimeUnit.SECONDS)) {
                scheduler.shutdown();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nAll collected food:");
        System.out.println(collectedFood);
        System.out.println("\nAfter food collected:");
        System.out.println(roomInHouse);
        System.out.println("All food collected");
    }
}
