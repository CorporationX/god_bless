package school.faang.miceverynice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class House {
    private final List<Room> rooms;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Food> collectFood() {
        Random random = new Random();
        List<Food> collectedFood = new ArrayList<>();

        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2;
        do {
            room2 = rooms.get(random.nextInt(rooms.size()));
        } while (room1 == room2);

        collectedFood.addAll(room1.getFoods());
        room1.getFoods().clear();

        collectedFood.addAll(room2.getFoods());
        room2.getFoods().clear();

        return collectedFood;
    }
}
