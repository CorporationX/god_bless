package school.BJS2_36058;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class House {

    private List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    int countOfCleanRooms = 0;

    public boolean isAll() {
        if (countOfCleanRooms == rooms.size()) {
            return true;
        }
        return false;
    }

    public void initialize() {
        for (int i = 1; i < 9; i++) {
            rooms.add(new Room("Номер комнаты: " + i));
        }
        for (Room room : rooms) {
            for (int i = 0; i < 10; i++) {
                room.addFood(new Food("Еда номер: " + i));
            }
        }
    }

    public void collectFood() {
        Random rand = new Random();
        Room room1 = rooms.get(rand.nextInt(rooms.size()));
        Room room2 = rooms.get(rand.nextInt(rooms.size()));
        synchronized (collectedFood) {
            if (room1.hasFood()) {
                room1.getFoods(collectedFood);
                countOfCleanRooms++;
            }
            if (room2.hasFood()) {
                room2.getFoods(collectedFood);
                countOfCleanRooms++;
            }
        }
    }
}
