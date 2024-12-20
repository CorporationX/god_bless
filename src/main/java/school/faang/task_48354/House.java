package school.faang.task_48354;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void initialize() {
        for (int i = 1; i <= 5; i++) {
            Room room = new Room();
            for (int j = 1; j <= 3; j++) {
                room.addFood(new Food("Food_" + i + "_" + j));
            }
            addRoom(room);
        }
    }

    public synchronized void collectFood() {
        if (rooms.size() < 2) {
            return;
        }

        Random random = new Random();
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));

        while (room1 == room2) {
            room2 = rooms.get(random.nextInt(rooms.size()));
        }

        if (room1.hasFood() && room2.hasFood()) {
            List<Food> foodFromRoom1 = room1.removeAllFood();
            List<Food> foodFromRoom2 = room2.removeAllFood();

            collectedFood.addAll(foodFromRoom1);
            collectedFood.addAll(foodFromRoom2);

            System.out.println("Collected food: " + foodFromRoom1 + " and " + foodFromRoom2);
        }
    }

    public boolean allFoodCollected() {
        return rooms.stream().noneMatch(Room::hasFood);
    }
}