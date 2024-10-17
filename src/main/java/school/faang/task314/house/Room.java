package school.faang.task314.house;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Food> foods = new ArrayList<>();

    public boolean hasFood() {
        return !foods.isEmpty();
    }

    public void removeFood() {
        foods.clear();
    }

    public List<Food> getAllfood() {
        return foods;
    }

    public void addFood(Food food) {
        foods.add(food);
    }
}
