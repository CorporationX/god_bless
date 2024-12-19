package school.faang.task_48283;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Room {
    private String name;
    private List<Food> foods = new ArrayList<>();

    public void addFoodToRoom(Food food) {
        foods.add(food);
    }

    public void removeFood() {
        foods.clear();
    }
}
