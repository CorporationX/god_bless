package school.faang.bjs_48570;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Room {
    private final String name;
    private final List<Food> foods = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foods.add(food);
    }
}
