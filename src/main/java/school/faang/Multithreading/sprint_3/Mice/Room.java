package school.faang.Multithreading.sprint_3.Mice;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class Room {
    private final String name;
    private final List<Food> foods = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeAllFood() {
        foods.clear();
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }
}
