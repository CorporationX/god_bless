package school.faang.schedulethreadpool;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private List<Food> foods = new ArrayList<>();

    public void addFood(Food food) {
        this.foods.add(food);
    }
}
