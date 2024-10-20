package miceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Room {
    private final List<Food> foods = new ArrayList<Food>();
    private String roomName;

    public void clearFoods() {
        foods.clear();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

}
