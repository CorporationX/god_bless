package BJS2_36187;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final int roomId;
    private static int roomQuantity = 0;
    private final List<Food> foodList = new ArrayList<>();

    public Room() {
        roomId = ++roomQuantity;
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    List<Food> getAndRemoveFood() {
        List<Food> foodToReturn = new ArrayList<>(foodList);
        foodList.clear();
        return foodToReturn;
    }

    public boolean isFoodInTheRoom(){
        return !foodList.isEmpty();
    }

    @Override
    public String toString() {
        return "Room number " + roomId + "  Food: " + foodList.toString();
    }
}
