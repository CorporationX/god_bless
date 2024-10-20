package tasks.bjs2_35987;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> foods;

    public List<Food> collectFoods() {
        List<Food> collectedFood = new ArrayList<>(foods);
        foods.clear();
        return collectedFood;
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }
}
