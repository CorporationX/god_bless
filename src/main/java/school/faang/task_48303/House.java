package school.faang.task_48303;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
    private static final int TOTAL_FOOD_COUNT = 10;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    private final Random random = new Random();

    public void initialize() {
        for (int i = 1; i <= 5; i++) {
            rooms.add(new Room());
        }

        int foodCounter = 0;
        while (foodCounter < TOTAL_FOOD_COUNT) {
            Room room = rooms.get(random.nextInt(rooms.size()));
            room.addFood(new Food("Еда " + (++foodCounter)));
        }
    }

    public synchronized void collectFood() {
        List<Room> roomsWithFood = rooms.stream()
                .filter(Room::hasFood)
                .toList();

        if (roomsWithFood.size() < 2) {
            return;
        }

        Room room1 = roomsWithFood.get(random.nextInt(roomsWithFood.size()));
        Room room2;

        do {
            room2 = roomsWithFood.get(random.nextInt(roomsWithFood.size()));
        } while (room1 == room2);

        System.out.println("Сбор еды из комнат...");
        collectedFood.addAll(room1.collectAllFood());
        collectedFood.addAll(room2.collectAllFood());
        System.out.println("Собрано: " + collectedFood.size() + " из " + TOTAL_FOOD_COUNT);
    }

    public boolean allFoodCollected() {
        return collectedFood.size() >= TOTAL_FOOD_COUNT;
    }
}