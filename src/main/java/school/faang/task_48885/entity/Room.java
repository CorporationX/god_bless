package school.faang.task_48885.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
public class Room {
    private final List<Food> foodList = new ArrayList<>();

    public Room() {
    }

    public void addFood(Food food) {
        if (food == null) {
            throw new NullPointerException("food");
        }
        foodList.add(food);
    }
}
