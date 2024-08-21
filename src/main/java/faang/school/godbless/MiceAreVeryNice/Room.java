package faang.school.godbless.MiceAreVeryNice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private String name;
    private final List<Food> food = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        this.food.add(food);
    }
}
