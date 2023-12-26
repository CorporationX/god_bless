package TomAndJerry;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Room {
    private final String name;
    private List<Food> foodList = new ArrayList<>();
    private boolean available = true;

    public Room(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foodList.add(food);
    }
}
