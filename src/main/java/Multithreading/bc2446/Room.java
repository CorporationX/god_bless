package Multithreading.bc2446;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private final List<Food> roomFoods = new ArrayList<>();

    public void addFood(Food food) {
        roomFoods.add(food);
    }

    public void removeFoods() {
        getRoomFoods().clear();
    }

}
