package school.faang.veryNice;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Food> foodList;

    public Room() {
        foodList = new ArrayList<>();
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void removeFood(Food food) {
        foodList.remove(food);
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }
}
