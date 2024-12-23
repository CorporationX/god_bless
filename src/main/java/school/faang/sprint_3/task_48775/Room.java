package school.faang.sprint_3.task_48775;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {
    private final List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        foodList.add(food);
    }

    public List<Food> clearAndGetFood() {
        List<Food> collected = new ArrayList<>(foodList);
        foodList.clear();
        return collected;
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }

    public List<Food> getFoodList() {
        return Collections.unmodifiableList(foodList);
    }
}
