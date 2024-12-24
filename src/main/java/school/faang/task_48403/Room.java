package school.faang.task_48403;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Getter
public class Room {
    private final int number;
    private final List<Food> foods = initializeFoods();

    private List<Food> initializeFoods() {
        List<Food> initialFoods = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            initialFoods.add(new Food("Food " + i));
        }
        return initialFoods;
    }

    public void removeFood() {
        foods.clear();
    }
}
