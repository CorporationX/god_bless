package faang.school.godbless.multithreading.mice;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();

    public static void main(String[] args) {

        List<Food> foods1 = Arrays.asList(
                new Food("Pizza"),
                new Food("Burger"),
                new Food("Sushi")
        );
        Room kitchen = new Room("Kitchen", new ArrayList<>(foods1));

        List<Food> foods2 = Arrays.asList(
                new Food("Pasta"),
                new Food("Salad"),
                new Food("Tacos")
        );
        Room diningRoom = new Room("Dining Room", new ArrayList<>(foods2));

        List<Food> foods3 = Arrays.asList(
                new Food("Steak"),
                new Food("Ice Cream"),
                new Food("Fruit Salad")
        );
        Room livingRoom = new Room("Living Room", new ArrayList<>(foods3));

        List<Food> foods4 = Arrays.asList(
                new Food("Sandwich"),
                new Food("Chips"),
                new Food("Soda")
        );
        Room pantry = new Room("Pantry", new ArrayList<>(foods4));

        List<Food> foods5 = Arrays.asList(
                new Food("Omelette"),
                new Food("Bacon"),
                new Food("Toast")
        );
        Room breakfastNook = new Room("Breakfast Nook", new ArrayList<>(foods5));

        List<Food> foods6 = Arrays.asList(
                new Food("Cake"),
                new Food("Cookies"),
                new Food("Brownies")
        );
        Room dessertRoom = new Room("Dessert Room", new ArrayList<>(foods6));

        House house = new House(Arrays.asList(kitchen, livingRoom, diningRoom, pantry, breakfastNook, dessertRoom));

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            threadPool.schedule(house::collectFood, i * 30, TimeUnit.SECONDS);
        }

        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(1, TimeUnit.MINUTES)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            threadPool.shutdownNow();
        }
        System.out.println("All food collected: " + house.collectedFood);
    }

    public synchronized void collectFood() {
        var roomsWithFood = rooms.stream()
                .filter(room -> !room.foodList().isEmpty())
                .limit(2)
                .toList();

        var foodList = roomsWithFood.stream()
                .flatMap(room -> room.foodList().stream())
                .toList();

        if (foodList.isEmpty()) {
            System.out.println("No more food in house!");
        } else {
            collectedFood.addAll(foodList);

            roomsWithFood.forEach(room -> room.foodList().clear());
            System.out.println("Collected food: " + foodList);
        }
    }


}
