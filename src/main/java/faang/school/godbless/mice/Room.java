package faang.school.godbless.mice;

import java.util.List;

public class Room {
    private List<Food> food;

    public List<Food> getFood() {
        return food;
    }

    public Room(List<Food> food) {
        this.food = food;
    }
}
