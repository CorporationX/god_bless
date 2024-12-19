package school.faang.task_48243;

import school.faang.exception.CheckException;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        if (food == null) {
            throw new CheckException("food");
        }

        foodList.add(food);
    }

    public List<Food> collectFood() {
        List<Food> collectedFood = new ArrayList<>(foodList);
        foodList.clear();
        return collectedFood;
    }

    public boolean isEmpty() {
        return foodList.isEmpty();
    }
}
