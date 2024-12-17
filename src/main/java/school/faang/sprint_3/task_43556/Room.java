package school.faang.sprint_3.task_43556;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private String name;
    private List<Food> foodList;

    public Room(String name, List<Food> foodList) {
        this.name = name;
        this.foodList = foodList;
    }

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
