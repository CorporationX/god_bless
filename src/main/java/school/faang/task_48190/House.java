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
    private List<Room> rooms;
    private List<Food> collectedFoods;

    public static void main(String[] args) {
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

        int bufferSize = 5;
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(bufferSize);

        executorService.scheduleAtFixedRate(
                () -> {
                    house.collectFood(executorService);
                    if (house.allFoodCollected()) {
                        executorService.shutdown();
                        System.out.println("All food was collected");
                    }
                }, 0, 30, TimeUnit.MILLISECONDS);
    }

    public void collectFood(ScheduledExecutorService executorService) {
        Random randomIndex = new Random();
        int firstIndex = randomIndex.nextInt(rooms.size());
        int secondIndex;
        do {
            secondIndex = randomIndex.nextInt(rooms.size());
        } while (firstIndex == secondIndex);

        Stream<Food> firstRandomFood = rooms.get(firstIndex).getFoods().stream();
        Stream<Food> secondRandomFood = rooms.get(secondIndex).getFoods().stream();
        collectedFoods = Stream.concat(firstRandomFood, secondRandomFood)
                .toList();

        rooms.get(firstIndex).getFoods().clear();
        rooms.get(secondIndex).getFoods().clear();

        System.out.println(collectedFoods);
    }

    public boolean allFoodCollected() {
        return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
    }
}
