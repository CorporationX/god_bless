package faang.school.godbless.House;

import lombok.Getter;
import java.util.*;

@Getter
public class Room {
    private String name;
    private List<Food> foodList;

    public Room(String name, List<Food> foodList) {
        this.name = name;
        this.foodList = foodList;
    }

    public List<Food> collectFood(){
        List<Food> collectedFood = new ArrayList<>(foodList);
        foodList.clear();
        return collectedFood;
    }

    @Override
    public String toString() {
        return name;
    }
}
