package faang.school.godbless.tomAndJerry;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Room {

    private final String name;
    private List<Food> foods;

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
