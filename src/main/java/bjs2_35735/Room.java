package bjs2_35735;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Getter
@AllArgsConstructor
public class Room {
    List<Food> food;

    public List<Food> removeFoodFromRoom() {
        List<Food> collectedFood = new ArrayList<>(food);
        food.clear();
        return collectedFood;
    }
}
