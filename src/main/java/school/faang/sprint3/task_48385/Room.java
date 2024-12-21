package school.faang.sprint3.task_48385;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public record Room(int id, @NonNull List<Food> foodList) {

    public List<Food> yieldAllFood() {
        List<Food> foodToReturn = List.copyOf(foodList);
        foodList.clear();
        return foodToReturn;
    }
}
