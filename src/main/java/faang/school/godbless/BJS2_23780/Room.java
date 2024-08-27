package faang.school.godbless.BJS2_23780;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Room {
    private final String name;
    private final List<Food> foodList;

    public Room(String name, List<Food> foodList) {
        this.name = name;
        this.foodList = new ArrayList<>(foodList);
    }

    public List<Food> collectFood() {
        List<Food> collectedFood = new ArrayList<>(foodList);
        foodList.clear();
        return collectedFood;
    }
}
