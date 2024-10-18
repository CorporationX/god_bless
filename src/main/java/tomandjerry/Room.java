package tomandjerry;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Room {
    private final String name;
    private final List<Food> foodList;

    public Room(String name) {
        this.name = name;
        this.foodList = new ArrayList<>();
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public List<Food> getFoodList() {
        return new ArrayList<>(foodList);
    }

    public void removeFood(Food food) {
        foodList.remove(food);
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }

    public void clearFood() {
        foodList.clear();
    }
}
