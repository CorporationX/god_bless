package school.faang.BJS2_36116;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Room {
    private List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        foodList.add(food);
    }

    public List<Food> removeAllFood() {
        List<Food> food = new ArrayList<>(foodList);
        foodList.clear();
        return food;
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }

    @Override
    public String toString() {
        if (hasFood()) {
            return "Room(еда=" + foodList + ")";
        } else {
            return "Room(еда=Нет еды)";
        }
    }
}
