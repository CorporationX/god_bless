package school.faang.sprint3.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
    List<Room> rooms = new ArrayList<>();

    public List<Food> collectFood() {
        Random random = new Random();
        int room1 = random.nextInt(rooms.size());
        int room2;
        do {
            room2 = random.nextInt(rooms.size());
        } while (room1 == room2);

        List<Food> room1Food = new ArrayList<>(rooms.get(room1).food);
        List<Food> room2Food = new ArrayList<>(rooms.get(room2).food);

        room1Food.addAll(room2Food);

        rooms.get(room2).food.clear();
        rooms.get(room1).food.clear();

        return room1Food;
    }

}

