package faang.school.godbless.mice_are_very_nice;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private List<Food> roomsFood;

    public Room() {
        this.roomsFood = new ArrayList<>();
    }

    public void addFood(Food food) {
        roomsFood.add(food);
    }

    public void clearFood() {
        roomsFood.clear();
    }
}