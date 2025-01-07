package school.faang.sprint_3.task_43556;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        Random random = new Random();
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));

        if (hasFood(room1, room2)) {
            System.out.println("Собираем еду в " + room1.name() + " и " + room2.name());
            collectedFood.addAll(room1.foodList());
            room1.removeAllFood();
            collectedFood.addAll(room2.foodList());
            room2.removeAllFood();
        }
    }

    public boolean hasFood(Room room1, Room room2) {
        return room1.hasFood() && room2.hasFood();
    }

    public boolean allFoodCollected() {
        return (int) rooms.stream()
                .filter(room -> room.foodList().isEmpty())
                .count() == rooms.size();
    }
}
