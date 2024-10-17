package school.faang.tomandjerry;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private List<Food> foodInRoom = new ArrayList<>();

    public void addFood(Food food) {
        if (food != null) {
            foodInRoom.add(food);
        } else {
            System.out.println("Food cannot be null!");
        }
    }

    public void removeAllFood(List<Food> foods) {
        foodInRoom.clear();
    }

    public boolean hasFood() {
        return !foodInRoom.isEmpty();
    }
}
