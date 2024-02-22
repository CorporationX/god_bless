package faang.school.godbless.TomAndJerry;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Room {
    private List<Food> foodList;

    public Room() {
        this.foodList = new ArrayList<>();
    }
    public void addFood(Food food) {
        foodList.add(food);
    }

    public void removeFood(Food food) {
        if (!foodList.isEmpty()) {
            foodList.remove(food);
        }
    }
}
