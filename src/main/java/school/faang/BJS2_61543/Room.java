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
    private final Object lock = new Object();

    public List<Food> clearFood() {
        synchronized (lock) {
            List<Food> collectedFood = new ArrayList<>(foodList);
            foodList.clear();
            return collectedFood;
        }
    }

    public boolean hasFood() {
        synchronized (lock) {
            return !foodList.isEmpty();
        }
    }

    public void addFood(@NonNull Food food) {
        synchronized (lock) {
            foodList.add(food);
        }
    }

    public void printAllFood() {
        synchronized (lock) {
            foodList.forEach(System.out::println);
        }
    }
}
