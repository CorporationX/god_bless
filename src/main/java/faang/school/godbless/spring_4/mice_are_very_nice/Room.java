package faang.school.godbless.spring_4.mice_are_very_nice;

import java.util.List;

public class Room {
    private final List<Food> foods;

    public Room(List<Food> foods) {
        this.foods = foods;
    }

    public List<Food> getFoods() {
        return foods;
    }
}
