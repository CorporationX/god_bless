package school.faang.BJS2_36163;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final List<Food> foods = new ArrayList<>();

    public void addFood(Food food) {
        foods.add(food);
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }
}
