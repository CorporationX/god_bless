package faang.school.godbless.thirdsprint.thomasandjerry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Room {
    @Getter
    private final String name;
    private final List<Food> foodList = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public List<Food> collectFood() {
        List<Food> collectedFood = new ArrayList<>(foodList);
        foodList.clear();
        return collectedFood;
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }

    @Override
    public String toString() {
        return name;
    }
}
