package faang.school.godbless.tomAndJerry;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {

    private final String name;
    private List<Food> foods;
    private int lock;

    public Room(String name) {
        this.name = name;
        this.foods = new ArrayList<>();
    }

    public void addFoodToRoom(Food food) {
        if (food != null) {
            this.foods.add(food);
        }
    }
}
