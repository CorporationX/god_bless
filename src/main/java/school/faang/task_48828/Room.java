package school.faang.task_48828;

import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

@Getter
public class Room {
    private final List<Food> foodList;
    private final int numberOfRoom;

    public Room(int numberOfRoom) {
        foodList = new ArrayList<>();
        this.numberOfRoom = numberOfRoom;
        createList();
    }

    private void createList() {
        for (int i = 0; i < 7; i++) {
            foodList.add(new Food("Food " + i));
        }
    }

    public List<Food> collectFood() {
        List<Food> list = new ArrayList<>(foodList);
        foodList.clear();
        return list;
    }

    public boolean isClear() {
        return foodList.isEmpty();
    }
}
