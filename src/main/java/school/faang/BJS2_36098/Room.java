package school.faang.BJS2_36098;

import lombok.Data;
import java.util.List;

@Data
public class Room {
    private List<Food> foodList;

    public Room(List<Food> foodList) {
        this.foodList = foodList;
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }

    public List<Food> collectFood() {
        List<Food> collectedFood = List.copyOf(foodList);
        foodList.clear();
        return collectedFood;
    }
}