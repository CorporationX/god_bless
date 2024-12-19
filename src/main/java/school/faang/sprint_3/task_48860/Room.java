package school.faang.sprint_3.task_48860;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private static final int FOODS_IN_ROOM = 5;
    private int roomNumber;
    private List<Food> foods;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        foods = new ArrayList<>();
        addRandomFood();
    }

    private void addRandomFood() {
        for (int i = 1; i <= FOODS_IN_ROOM; i++) {
            foods.add(new Food("Еда №" + i));
        }
    }

    public void removeAllFood() {
        foods.clear();
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }
}
