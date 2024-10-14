package school.faang.micenice;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Room {
    private final List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        foodList.add(food);
    }
    public void removeAllFood() {
        foodList.clear();
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }
}
