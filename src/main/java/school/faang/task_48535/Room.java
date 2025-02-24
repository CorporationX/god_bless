package school.faang.task_48535;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private final List<Food> foodList;

    public Room() {
        this.foodList = new ArrayList<>();
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }
}
