package school.faang.task_48273;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Room {
    private final int number;
    private final List<Food> foods = new ArrayList<>();

    public List<Food> collectFood() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        List<Food> collectedFood = new ArrayList<>(foods);
        foods.clear();
        log.info("Collected food from room {}: {}", number, collectedFood);
        return collectedFood;
    }

    public void addFood(@NonNull Food food) {
        foods.add(food);
    }
}
