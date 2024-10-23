package school.faang.sprint3.homes;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Food> foods;

    public Room() {
        this.foods = new ArrayList<>();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }
}
