package faang.school.godbless.BJS2_23755;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class House {
    private final static int NUMS_THREADS = 5;
    private final static int ROOMS_LIMIT = 2;
    static List<Food> allFood = new ArrayList<>();
    List<Room> rooms = List.of(
            new Room(new ArrayList<>(Arrays.asList(new Food("Apple"), new Food("Milk")))),
            new Room(new ArrayList<>(Arrays.asList(new Food("Bread"), new Food("Cheese"), new Food("Juice")))),
            new Room(new ArrayList<>(Arrays.asList(new Food("Tomato"), new Food("Meat"), new Food("Cola")))),
            new Room(new ArrayList<>(Arrays.asList(new Food("Milk"), new Food("Beer"), new Food("Cola")))),
            new Room(new ArrayList<>(Arrays.asList(new Food("Cheese"), new Food("Apple"), new Food("Juice")))),
            new Room(new ArrayList<>(Arrays.asList(new Food("Burrito"), new Food("Hamburger"), new Food("Coffee")))),
            new Room(new ArrayList<>(Arrays.asList(new Food("Tea"), new Food("Banana")))),
            new Room(new ArrayList<>(Arrays.asList(new Food("Chocolate"), new Food("Cola")))),
            new Room(new ArrayList<>(Arrays.asList(new Food("Watermelon"), new Food("Pancake")))),
            new Room(new ArrayList<>(Arrays.asList(new Food("Chicken"), new Food("Melon"), new Food("Tea"))))
    );

    public static void main(String[] args) {
        House house = new House();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < NUMS_THREADS; i++) {
            executor.schedule(house::collectFood, 30 * (i + 1), TimeUnit.SECONDS);
        }
        try {
            executor.shutdown();
            if (executor.awaitTermination(300, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (!executor.isTerminated()) {

        }
        allFood.forEach(food -> System.out.println(food.getName()));
    }

    public List<Food> collectFood() {
        List<Food> foodList;
        foodList = rooms.stream()
                .filter(room -> !room.getFoodList().isEmpty())
                .limit(ROOMS_LIMIT)
                .flatMap(room -> room.getFoodList().stream()
                )
                .collect(Collectors.toList());

        allFood.addAll(foodList);
        removeFood();
        return foodList;
    }

    public void removeFood() {
        rooms.stream()
                .filter(room -> !room.getFoodList().isEmpty())
                .limit(ROOMS_LIMIT)
                .forEach(room -> room.getFoodList().clear());
    }
}
