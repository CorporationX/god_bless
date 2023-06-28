package mice_are_very_nice;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Food> foodInTheRoom = new ArrayList<>();

    public List<Food> getFoodInTheRoom() {
        return foodInTheRoom;
    }

    public void addFood(Food food) {
        foodInTheRoom.add(food);
    }

    public void removeFood() {
        foodInTheRoom.clear();
    }
}
