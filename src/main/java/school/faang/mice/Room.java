package school.faang.mice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room {

    @Getter
    private final String name;
    private final List<Food> foods = new ArrayList<>();

    public Room(String name) {
        Objects.requireNonNull(name, "Name cannot be null");
        this.name = name;
    }

    public void addFood(Food food) {
        Objects.requireNonNull(food, "Food cannot be null");
        foods.add(food);
    }

    public List<Food> removeAllFood() {
        List<Food> removedFoods = new ArrayList<>(foods);
        foods.clear();
        return removedFoods;
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }
}
