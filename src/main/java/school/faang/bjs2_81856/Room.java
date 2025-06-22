package school.faang.bjs2_81856;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Room {
    private final List<Food> foodList;

    public List<Food> clearFoodList() {
        List<Food> result = new ArrayList<>(foodList);
        foodList.clear();
        return result;
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }
}
