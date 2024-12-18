package school.faang.task_48394;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private final List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        foodList.add(food);
    }

    public void clearRoom() {
        foodList.clear();
    }

    public void addFoodList(List<Food> list) {
        foodList.addAll(list);
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }
}
