package school.faang.multithreading.miceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Room {
    private List<Food> foodList;
    private int number;

    public boolean hasFood() {
        return !foodList.isEmpty();
    }

    public List<Food> collectFood() {
        List<Food> food = foodList;
        foodList.clear();
        return food;
    }

}
