package school.faang.task_48314;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final List<Food> foodList;

    public Room() {
        this.foodList = new ArrayList<>();
    }

    public void addFood(@NonNull Food food) {
        foodList.add(food);
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }

    public List<Food> removeAllFoodFromRoom() {
        List<Food> result = new ArrayList<>(foodList);
        foodList.clear();
        return result;
    }

}
