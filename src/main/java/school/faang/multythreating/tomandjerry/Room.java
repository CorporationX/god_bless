package school.faang.multythreating.tomandjerry;

import java.util.List;
import lombok.Getter;

@Getter
public class Room {
    private List<Food> foodList;

    public Room(List<Food> foodList) {
        this.foodList = foodList;
    }

    public void clearFoodList() {
        foodList = List.of();
    }

    @Override
    public String toString() {
        return "Room{" +
                "foodList=" + foodList +
                '}';
    }
}
