package school.faang.sprint_3.task_48584;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private final List<Food> foods = new ArrayList<>();
    private final String name;

    public Room(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        if (food != null) {
            foods.add(food);
        }
    }

    public List<Food> takeAllFood() {
        List<Food> listFood = new ArrayList<>(foods);
        foods.clear();
        System.out.println("Поток " + Thread.currentThread().getName() + " собрал еду в комнате " + name);
        return listFood;
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }
}
