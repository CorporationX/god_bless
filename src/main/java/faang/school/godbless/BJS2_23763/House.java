package faang.school.godbless.BJS2_23763;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public synchronized void collectFood(Room roomOne, Room roomTwo) {
        Food foodOne = roomOne.getFood();
        collectedFood.add(foodOne);
        Food foodTwo = roomTwo.getFood();
        collectedFood.add(foodTwo);

        System.out.println(foodOne + " and " + foodTwo + " collected");
    }
}
