package school.faang.task_48922;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private final String name;
    private final List<Food> foodList;

    public Room(String name) {
        this.name = name;
        this.foodList = new ArrayList<>();
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public List<Food> removeAllFood() {
        List<Food> removedFood = new ArrayList<>(foodList);
        foodList.clear();
        return removedFood;
    }

}

