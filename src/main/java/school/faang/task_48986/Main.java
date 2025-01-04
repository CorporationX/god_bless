package school.faang.task_48986;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int CORE_POOL_SIZE = 5;
    private static final long PERIOD = 30;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static volatile boolean allFoodCollected = false;

    public static void main(String[] args) {
        List<String> deliveryFood = List.of(
                "strawberry", "whipped cream", "cheese",
                "smoked sausages", "bread", "bananas",
                "cookies", "fries", "milk shake", "orange juice",
                "donuts", "chicken", "salmon", "butter",
                "toasted bread", "coffee"
        );

        List<String> spaceInventory = List.of(
                "kitchen", "children bedroom", "dining room",
                "bathroom", "primary bedroom", "hall", "workshop"
        );

        List<Food> foodList = deliveryFood.stream()
                .map(Food::new)
                .toList();

        List<Room> rooms = spaceInventory.stream()
                .map(roomName -> new Room(roomName, new ArrayList<>()))
                .toList();

        House house = new House(rooms);

        Random random = new Random();
        for (Food food : foodList) {
            Room randomRoom = rooms.get(random.nextInt(rooms.size()));
            randomRoom.getFood().add(food);
        }

        for (Room room : house.getRooms()) {
            System.out.println(room);
        }

        System.out.println();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        List<Room> randomRooms = house.selectedRooms();

        for (int i = 0; i < CORE_POOL_SIZE; i++) {
            scheduleTask(executorService, randomRooms);
        }
    }

    private static void scheduleTask(ScheduledExecutorService executorService, List<Room> randomRooms) {
        executorService.scheduleAtFixedRate(() -> {
            if (randomRooms.stream().anyMatch(room -> !room.getFood().isEmpty())) {
                Random randomOne = new Random();
                Room randomRoom = randomRooms.get(randomOne.nextInt(randomRooms.size()));
                if (!randomRoom.getFood().isEmpty()) {
                    Food collectedFood = randomRoom.pickFood();
                    System.out.println(
                            "Thread " + Thread.currentThread().getName()
                                    + " collected food: " + collectedFood);
                }
            } else {
                synchronized (Main.class) {
                    if (!allFoodCollected) {
                        executorService.shutdownNow();
                        allFoodCollected = true;
                        System.out.println("All food has been collected!");
                        System.out.println("The food was picked from: " + randomRooms);
                    }
                }
            }
        }, 0, PERIOD, TIME_UNIT);
    }
}