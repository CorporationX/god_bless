package school.faang.task_48704;

import lombok.Data;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Data
public class House {
    private List<Room> rooms;
    private List<Food> allFoods = new ArrayList<>();
    private int quantityRoom = 2;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public boolean collectFood() {
        for (int i = 0; i < quantityRoom; i++) {
            Room room = randomRooms();
            if (!room.getFoods().isEmpty()) {
                allFoods.addAll(room.getFoods());
                room.getFoods().removeAll(room.getFoods());
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
