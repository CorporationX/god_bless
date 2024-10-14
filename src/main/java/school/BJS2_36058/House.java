package school.BJS2_36058;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class House {


    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();

    public boolean isAll() {
        for (Room room : rooms) {
            if (room.hasFood()) {
                return false;
            }
        }
        return true;
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
        for (int i = 0; i < 2; i++) {
            Room room = rooms.get(rand.nextInt(rooms.size()));
            room.getFoods(collectedFood);
        }
    }
}
