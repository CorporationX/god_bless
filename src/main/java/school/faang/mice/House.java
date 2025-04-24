package school.faang.mice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class House {
    private final List<Room> rooms = new ArrayList<>();
    public final List<Food> collectedFood = new ArrayList<>();

    public void collectFood() {
        Collections.shuffle(rooms);
        for (int i = 0; i < 2; i++) {
            collectedFood.addAll(rooms.get(i).getFoods());
            rooms.get(i).getFoods().clear();
        }
    }

    public boolean checkCollectedFood() {
        return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
    }
}
