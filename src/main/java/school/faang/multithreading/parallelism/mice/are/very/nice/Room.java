package school.faang.multithreading.parallelism.mice.are.very.nice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private final int number;
    private List<Food> foods = new ArrayList<>();

    public Room(int number) {
        this.number = number;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }

    public List<Food> removeAllFood() {
        List<Food> foodsCopy = new ArrayList<>(foods);
        foods.clear();
        return foodsCopy;
    }
}
