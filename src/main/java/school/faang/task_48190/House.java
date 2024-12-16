package school.faang.task_48190;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
public class House {
    private final List<Room> rooms;
    private List<Food> collectedFoods;
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

    public void collectFood() {
        if (rooms.size() < 2) {
            System.out.println("No rooms!");
            return;
        }

        Random randomIndex = new Random();
        int firstIndex;
        while (true) {
            firstIndex = randomIndex.nextInt(rooms.size());
            if (!rooms.get(firstIndex).getFoods().isEmpty()) {
                break;
            }
        }

        int secondIndex;
        while (true) {
            secondIndex = randomIndex.nextInt(rooms.size());
            if (firstIndex != secondIndex && !rooms.get(secondIndex).getFoods().isEmpty()) {
                break;
            }
        }

        Stream<Food> firstRandomFood = rooms.get(firstIndex).getFoods().stream();
        Stream<Food> secondRandomFood = rooms.get(secondIndex).getFoods().stream();
        collectedFoods.addAll(Stream.concat(firstRandomFood, secondRandomFood).toList());

        rooms.get(firstIndex).getFoods().clear();
        rooms.get(secondIndex).getFoods().clear();

        System.out.println(collectedFoods);
    }

    public boolean allFoodCollected() {
        return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
    }
}
