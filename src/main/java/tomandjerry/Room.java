package tomandjerry;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        foodList.add(food);
    }

    public void removeAllFood() {
        foodList.clear();
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }
}
