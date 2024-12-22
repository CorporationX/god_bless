package school.faang.moduleone.sprintthree.task_43556;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private final List<Food> foods;
    private final int roomNumber;

    public Room(int number) {
        this.foods = new ArrayList<>();
        this.roomNumber = number;
        addFoodToRoom();
    }

    public List<Food> collectFood() {
        List<Food> collectedFood = new ArrayList<>(foods);
        foods.clear();
        return collectedFood;
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }

    private void addFoodToRoom() {
        for (int i = 0; i < 5; i++) {
            foods.add(new Food("food from room # " + roomNumber + " : " + i));
        }
    }
}
