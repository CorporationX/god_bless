package faang.school.godbless.parallelism.tomAndJerry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class Room {
    private String name;
    private List<Food> foodList;

    public Room(String name, List<Food> foodList) {
        this.name = name;
        this.foodList = foodList;
    }

    public List<Food> collectFoodFromRoom() {
        var removedFood = foodList.stream().toList();
        foodList = new ArrayList<>();

        return removedFood;
    }
}
