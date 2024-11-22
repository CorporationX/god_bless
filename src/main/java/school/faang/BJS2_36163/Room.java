package school.faang.BJS2_36163;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Food> foodList;
    @Getter
    private final int roomNumber;
    private boolean isCollected;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.foodList = new ArrayList<>();
        this.isCollected = false;
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public List<Food> getFood() {
        List<Food> food = new ArrayList<>(foodList);
        foodList.clear();
        return food;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void markAsCollected() {
        isCollected = true;
    }
}
