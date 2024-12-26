package school.faang.task48606;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
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
        log.info("Поток {}  собрал еду в комнате {}", Thread.currentThread().getName(), name);
        return listFood;
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }
}