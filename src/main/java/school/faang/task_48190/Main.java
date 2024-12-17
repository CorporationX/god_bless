package school.faang.task_48190;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int BUFFER_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        List<Food> foods = List.of(
                new Food("apple"), new Food("banana"), new Food("meat"), new Food("cheese"),
                new Food("fish"), new Food("bread"), new Food("milk"), new Food("eggs"),
                new Food("chocolate"), new Food("butter")
        );

        List<Room> rooms = List.of(
                new Room(new ArrayList<>(List.of(foods.get(0), foods.get(1), foods.get(8)))),
                new Room(new ArrayList<>(List.of(foods.get(2), foods.get(3), foods.get(4)))),
                new Room(new ArrayList<>(List.of(foods.get(5), foods.get(6), foods.get(7)))),
                new Room(new ArrayList<>(List.of(foods.get(9), foods.get(8), foods.get(0)))),
                new Room(new ArrayList<>(List.of(foods.get(3), foods.get(5), foods.get(6), foods.get(7))))
        );

        House house = new House(rooms, new ArrayList<>());
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(BUFFER_SIZE);

        executorService.scheduleWithFixedDelay(
                () -> {
                    synchronized (house) {
                        house.collectFood();
                        if (house.allFoodCollected()) {
                            executorService.shutdown();
                            System.out.println("All food was collected");
                        }
                    }
                }, 0, 5000, TimeUnit.MILLISECONDS);

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Forcing shutdown...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for termination");
            executorService.shutdownNow();
        }
    }
}
