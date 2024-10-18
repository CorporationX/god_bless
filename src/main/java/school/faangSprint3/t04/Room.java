package school.faangSprint3.t04;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        foodList.add(food);
    }

    public Food removeFood() {
        if (!foodList.isEmpty()) {
            return foodList.remove(0);
        }
        return null;
    }
}