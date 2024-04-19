package faang.school.godbless.mice_are_very_nice;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final List<Food> roomsFood;

    public Room() {
        this.roomsFood = new ArrayList<>();
    }

    public void addFood(Food food) {
        roomsFood.add(food);
    }

    public List<Food> getRoomsFood() {
        return roomsFood;
    }

    public void clearFood() {
        roomsFood.clear();
    }
}
