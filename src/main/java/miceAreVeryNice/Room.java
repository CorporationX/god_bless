package miceAreVeryNice;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Room {
    private final List<Food> foods = new ArrayList<>();
    private String roomName;

    public void addFood(Food food) {
        foods.add(food);
    }

    public List<Food> collectFood() {
        List<Food> result = foods;
        foods.clear();
        return result;
    }

}
