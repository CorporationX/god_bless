package school.faang.nicemice;

import lombok.Getter;

import java.util.List;

@Getter
public class Room {
    private final String name;
    private final List<Food> foods;

    public Room(String name, List<Food> foods) {
        this.name = name;
        this.foods = foods;
    }

    public void removeAllFood() {
        foods.clear();
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }
}
