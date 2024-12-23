package school.faang.sprint_3.task_48497;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Room {
    private final List<Food> foods = new ArrayList<>();
    private final int roomNumber;

    public void addFood(Food food) {
        foods.add(food);
    }

    public List<Food> collectFood() {
        List<Food> foodList = new ArrayList<>(foods);
        foods.clear();
        log.info("Collected {} food from room {}: {}", Thread.currentThread().getName(), roomNumber,
            foodList);
        return foodList;
    }
}
