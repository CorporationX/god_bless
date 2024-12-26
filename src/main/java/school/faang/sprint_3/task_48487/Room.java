package school.faang.sprint_3.task_48487;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        foodList.add(food);
    }

    public List<Food> removeAllFood() {
        List<Food> removedFood = new ArrayList<>(foodList);
        foodList.clear();
        return removedFood;
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }

    @Override
    public String toString() {
        return "Room{" + "foodList=" + foodList + '}';
    }
}
