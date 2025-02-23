package school.faang.BJS2_61543;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Room {

    @Getter
    private int roomNumer;
    private final List<Food> foodList = new ArrayList<>();

    public List<Food> clearFood() {
        List<Food> collectedFood = new ArrayList<>(foodList);
        foodList.clear();
        return collectedFood;
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }

    public void addFood(@NonNull Food food) {
        foodList.add(food);
    }

    public void printAllFood() {
        foodList.forEach(System.out::println);
    }
}
