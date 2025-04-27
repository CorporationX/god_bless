package school.faang.mice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Room {
    private final int roomNumber;
    private final List<Food> foods = new ArrayList<>();

    public List<Food> clearRoom() {
        List<Food> listFood = new ArrayList<>(foods);
        foods.clear();
        return listFood;
    }

    public void addFood(Food food) {
        foods.add(food);
    }
}

