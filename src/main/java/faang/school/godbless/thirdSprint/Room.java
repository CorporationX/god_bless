package faang.school.godbless.thirdSprint;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private String name;
    private List<Food> foodInsideRoom;

    public Room(String name) {
        this.name = name;
        foodInsideRoom = new ArrayList<>();
    }

    public void removeFood() {
        foodInsideRoom.clear();
    }

    public void addFood(Food food) {
        foodInsideRoom.add(food);
    }
}
