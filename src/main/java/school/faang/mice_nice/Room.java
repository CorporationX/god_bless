package school.faang.mice_nice;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final String name;
    private List<Food> foods;

    public Room(String name, List<Food> foods) {
        this.name = name;
        this.foods = foods;
    }

    public List<Food> collect() {
        List<Food> result = new ArrayList<>(foods);
        foods = new ArrayList<>();
        return result;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public String getName() {
        return name;
    }
}