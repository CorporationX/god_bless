package school.faang.task_48273;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Room {
    private final String name;
    private final List<Food> foods = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public List<Food> collectFood() {
        List<Food> collectedFood = new ArrayList<>(foods);
        foods.clear();

        log.info("Collected food from {}: {}", getName(), collectedFood);
        return collectedFood;
    }

    public void addFood(Food food) {
        foods.add(food);
    }
}
