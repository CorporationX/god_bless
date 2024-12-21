package school.faang.task_48303;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private final int number;
    private final List<Food> foodList = new ArrayList<>();

    public Room(int number) {
        this.number = number;
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }

    public List<Food> collectAllFood() {
        List<Food> collected = new ArrayList<>(foodList);
        foodList.clear();
        return collected;
    }

    public void addFood(Food food) {
        foodList.add(food);
    }
}