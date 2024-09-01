package faang.school.godbless.MiceAreVeryNice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private String name;
    private List<Food> foods = new ArrayList<>();

    public Room(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Room name cannot be null or empty");
        }
        this.name = name;
    }

    public void addFood(Food food) {
        if (food != null) {
            foods.add(food);
        }
    }

    public void clearFoods() {
        foods.clear();
    }
}