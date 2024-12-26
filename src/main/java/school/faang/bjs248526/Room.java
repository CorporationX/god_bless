package school.faang.bjs248526;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Room {
    private final String name;
    private final List<Food> foodList;

    public Room(String name, List<Food> foodList) {
        this.name = name;
        this.foodList =  Collections.synchronizedList(new ArrayList<>(foodList));
    }

    @Override
    public String toString() {
        return "Room{name='" + name + "', foodList=" + foodList + '}';
    }

    public boolean hasFood() {
        //System.out.printf("%s hasFood check on thread %s\n", this.name, Thread.currentThread().getId());
        return !foodList.isEmpty();
    }

    public void removeFood(Food food) {
        foodList.remove(food);
    }
}
