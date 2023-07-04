package faang.school.godbless.tom_ang_jerry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {

    private String name;
    private List<Food> foodInTheRoom = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foodInTheRoom.add(food);
    }

    public void removeFoodFromTheRoom() {
        foodInTheRoom.clear();
    }
}
