package faang.school.godbless.mt.mice;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final List<Food> foods;

    public Room(List<Food> foods) {
        this.foods = new ArrayList<>(foods);
    }

    public List<Food> takeFood() {
        List<Food> takenFood = new ArrayList<>(foods);
        foods.clear();
        return takenFood;
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }
}
