package BJS2_23820_MiceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class House {
    private static final int THREAD_POOL = 5;
    private static final List<Room> rooms = new ArrayList<>();
    private static final List<Food> collectedFood = new ArrayList<>();

    public static void main(String[] args) {
        List<Food> foodList = Arrays.asList(
                new Food("Pizza"),
                new Food("Apple"),
                new Food("Orange"),
                new Food("Sausages"),
                new Food("Bananas")
        );

        rooms.addAll(Arrays.asList(
                new Room("Kitchen", new ArrayList<>(foodList)),
                new Room("Dining room", new ArrayList<>(foodList))
        ));

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL);
        int delay = 0;
        for (int i = 0; i < THREAD_POOL; i++) {
            executor.schedule(House::collectFood, delay, TimeUnit.SECONDS);
            delay += 30;
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(3, TimeUnit.MINUTES)) {
                System.out.println("________________________________________");
                System.out.println("______Food in house are collected!______");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public static void collectFood() {
        System.out.println(Thread.currentThread().getName() + " was initiated");

        for (Room room : rooms) {
            if (!room.getFoodList().isEmpty()) {
                System.out.println("Collecting food from " + room.getRoomName());
                collectedFood.add(room.getFoodList().get(0));
                room.getFoodList().remove(room.getFoodList().get(0));
            }
            else {
                System.out.println("All food have been collected and room " + room.getRoomName() + " is clear!");
            }
        }
    }
}
