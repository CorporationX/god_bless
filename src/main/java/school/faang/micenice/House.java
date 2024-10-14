package school.faang.micenice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class House {
    private static final Random random = new Random();
    private final List<Room> house = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public void initialize() {
        List<String> foodNames = Arrays.asList("Banana", "Pizza", "Burger", "Apple", "Watermelon", "Ice cream");
        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("Threads started initializing.");
        for (int i = 0; i < random.nextInt(5, 10); i++) {
            executor.execute(() -> {
                Room room = new Room();
                int foodCount = random.nextInt(1, foodNames.size());
                for (int j = 0; j < foodCount; j++) {
                    Food food = new Food(foodNames.get(j));
                    room.addFood(food);
                }
                synchronized (house) {
                    house.add(room);
                }
            });
        }
        executor.shutdown();
        System.out.println("Initialing completed:");
        house.forEach(System.out::println);
    }

    public void collectFood() {
        List<Room> selectedRooms = List.of(
                house.get(random.nextInt(house.size())),
                house.get(random.nextInt(house.size()))
        );
        selectedRooms.stream()
                .filter(Room::hasFood)
                .forEach(room -> {
                    collectedFood.addAll(room.getFoodList());
                    room.removeAllFood();
                });
    }

    public boolean allFoodCollected() {
        return house.stream()
                .noneMatch(Room::hasFood);
    }
}
