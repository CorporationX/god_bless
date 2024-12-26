package school.faang.sprint_3.task_48487;

import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ToString
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    private final Random random = new Random();

    public void collectFood() {
        if (rooms.size() < 2) {
            System.out.println("Not enough rooms to collect food.");
            return;
        }

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

            System.out.println("Collected food from two rooms: " + foodFromRoom1 + ", " + foodFromRoom2);
        } else {
            System.out.println("One or both rooms have no food.");
        }
    }

    public boolean allFoodCollected() {
        return rooms.stream().noneMatch(Room::hasFood);
    }

    public void initialize() {
        for (int i = 0; i < 5; i++) {
            Room room = new Room();
            for (int j = 0; j < random.nextInt(5) + 1; j++) {
                room.addFood(new Food("Food-" + i + "-" + j));
            }
            addRoom(room);
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
