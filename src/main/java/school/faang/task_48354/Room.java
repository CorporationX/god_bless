package school.faang.task_48354;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        foodList.add(food);
    }

    public List<Food> removeAllFood() {
        List<Food> collectedFood = new ArrayList<>(foodList);
        foodList.clear();
        return collectedFood;
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }
}