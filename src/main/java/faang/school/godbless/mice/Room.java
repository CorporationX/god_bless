package faang.school.godbless.mice;

import java.util.List;


public class Room {
    private String name;
    List<Food> foods;

    public Room(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foods.add(food);
    }
}
