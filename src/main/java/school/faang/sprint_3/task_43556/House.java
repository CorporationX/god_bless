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

        if (room1.hasFood() && room2.hasFood()) {
            System.out.println("Собираем еду в " + room1.getName() + " и " + room2.getName());
            collectedFood.addAll(room1.getFoodList());
            room1.removeAllFood();
            collectedFood.addAll(room2.getFoodList());
            room2.removeAllFood();
        }
    }

    public boolean allFoodCollected() {
        int count = 0;
        for (Room room : rooms) {
            if (room.getFoodList().isEmpty()) {
                count++;
            }
        }
        return count == rooms.size();
    }
}
