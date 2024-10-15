package school.faang.mice_are_nice_BJS2_35995;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private List<Food> food;

    public void addFood(Food food) {
        this.food.add(food);
    }

    public void deleteAllFood() {
        food.clear();
    }
}
