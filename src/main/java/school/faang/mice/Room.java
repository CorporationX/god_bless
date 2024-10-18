package school.faang.mice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        foodList.add(food);
    }
}
