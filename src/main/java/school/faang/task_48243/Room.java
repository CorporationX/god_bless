package school.faang.task_48243;

import lombok.Getter;
import school.faang.exception.CheckException;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private final List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        if (food == null) {
            throw new CheckException("food");
        }

        foodList.add(food);
    }

    public void removeAllFood() {
        foodList.clear();
    }

    public boolean isEmpty() {
        return foodList.isEmpty();
    }
}
