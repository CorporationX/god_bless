package school.faang.task_48704;

import lombok.Data;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class House {
    private static final int ROOMS_TO_CHECK_COUNT = 2;
    private List<Room> rooms;
    private List<Food> allFoods = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = Objects.requireNonNull(rooms, "List of rooms cannot be null");
    }

    public synchronized boolean collectFood() {
        for (int i = 0; i < ROOMS_TO_CHECK_COUNT; i++) {
            Room room = randomRooms();
            if (!room.getFoods().isEmpty()) {
                allFoods.addAll(room.getFoods());
                room.getFoods().clear();
                System.out.println("Комната " + room.getName() + " обобрана");
            } else if (!allFoodCollected()) {
                System.out.println("Комната " + room.getName() + " была пуста");
            } else {
                System.out.println("Еда в доме собрана!");
                return true;
            }
        }
        return false;
    }

    public boolean allFoodCollected() {
        for (Room room : rooms) {
            if (!room.getFoods().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private Room randomRooms() {
        var random = new SecureRandom();
        return rooms.get(random.nextInt(rooms.size()));
    }
}
