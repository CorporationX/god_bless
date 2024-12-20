package school.faang.bjs248526;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final List<Room> roomsList = Collections.synchronizedList(new ArrayList<>());
    private static final List<Food> collectedFood = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        House house = new House();
        house.initData();
        System.out.println("House setup : " + roomsList);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(Constants.THREADS);

        executor.scheduleAtFixedRate(() -> house.collectFood(executor), 0, 3, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
            System.out.println("Food collection at home completed! : " + collectedFood);
        }));
    }

    private static void initData() {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(10); i++) {
            List<Food> food = new ArrayList<>();
            for (int j = 0; j < random.nextInt(5); j++) {
                food.add(new Food("Food no: " + j + " for room no: " + i));
            }
            roomsList.add(new Room("Room no: " + i, food));
        }
    }

    private boolean allFoodCollected() {
        return roomsList.stream().allMatch(rm -> rm.getFoodList().isEmpty());
    }

    private void collectFood(ScheduledExecutorService executor) {
        Random random = new Random();
        synchronized (roomsList) {
            for (int i = 0; i < Constants.ROOMS; i++) {
                long nonEmptyRoomsCount = roomsList.stream().filter(rm -> !rm.getFoodList().isEmpty()).count();
                if (nonEmptyRoomsCount == 0) {
                    executor.shutdown();
                    System.out.println("No more food to collect.");
                    return;
                }
                Room room = roomsList.get(random.nextInt((int) roomsList.stream()
                        .filter(rm -> !rm.getFoodList().isEmpty()).count()));
                var foodData = room.getFoodList().stream().findFirst().orElseThrow(IllegalStateException::new);
                collectedFood.add(foodData);
                System.out.println("Food collected : " + foodData);
                room.getFoodList().remove(foodData);
                if (room.getFoodList().isEmpty()) {
                    roomsList.remove(room);
                }
            }
        }
    }
}
