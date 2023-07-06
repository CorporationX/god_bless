package faang.school.godbless.multithreading.parallelism_thread.tom_jerry;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Room {
    private List<Food> foods = new ArrayList<>();

    public Food getFood() {
        if (foods.isEmpty()) throw new IllegalArgumentException("В комнате больше нет еды");
        var food = foods.get(foods.size() - 1);
        foods.remove(foods.size() - 1);
        System.out.println("Еду " + food.toString() + " забрали");
        return food;
    }

    public void addFood(Food food) {
        foods.add(food);
    }
}
